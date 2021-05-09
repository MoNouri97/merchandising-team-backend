package com.example.merchteam.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.merchteam.util.JwtUtil;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;

public class JwtValidateFilter extends OncePerRequestFilter {
	private final JwtUtil jwtUtil;

	public JwtValidateFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(
		HttpServletRequest request,
		HttpServletResponse response,
		FilterChain filterChain
	) throws ServletException,
		IOException {
		String authHeader = request.getHeader(jwtUtil.getAuthorizationHeader());
		String jwt = jwtUtil.extractToken(authHeader);
		// no token present
		if (jwt == null) {
			filterChain.doFilter(request, response);
			return;
		}

		try {
			// parse token
			Claims claims = jwtUtil.extractClaims(jwt);
			// user
			var user = jwtUtil.extractUserInfo(claims);
			// authorities List must be mapped tp Set
			Set<SimpleGrantedAuthority> authorities = jwtUtil.extractAuthorities(claims);
			// authenticate user
			Authentication authentication = new UsernamePasswordAuthenticationToken(
				user,
				null,
				authorities
			);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (Exception e) {
			// System.out.println(e);
			throw new IllegalStateException("token cannot be trusted !!!");
		}

		filterChain.doFilter(request, response);

	}

}
