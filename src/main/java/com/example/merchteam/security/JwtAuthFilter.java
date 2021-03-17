package com.example.merchteam.security;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.merchteam.model.AuthRequest;
import com.example.merchteam.model.AuthResponse;
import com.example.merchteam.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;

	@Autowired
	public JwtAuthFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(
		HttpServletRequest request,
		HttpServletResponse response
	) throws AuthenticationException {
		try {
			// map the request to UsernamePasswordAuthRequest.class
			AuthRequest reqValue = new ObjectMapper().readValue(
				request.getInputStream(),
				AuthRequest.class
			);
			// authenticate the request
			Authentication authentication = new UsernamePasswordAuthenticationToken(
				reqValue.getUsername(),
				reqValue.getPassword()
			);
			return authenticationManager.authenticate(authentication);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(
		HttpServletRequest request,
		HttpServletResponse response,
		FilterChain chain,
		Authentication authResult
	) throws IOException,
		ServletException {

		String authHeader = jwtUtil.generateAuthHeaderValue(
			authResult.getName(),
			Map.of("authorities", authResult.getAuthorities())
		);
		response.addHeader(jwtUtil.getAuthorizationHeader(), authHeader);
		AuthResponse authResponse = new AuthResponse(authHeader, authResult.getName());
		new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
			.writeValue(response.getWriter(), authResponse);
	}
}
