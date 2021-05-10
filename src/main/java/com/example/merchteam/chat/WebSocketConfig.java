package com.example.merchteam.chat;

import java.util.Set;

import com.example.merchteam.util.JwtUtil;
import com.example.merchteam.util.JwtUtil.JwtUserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import io.jsonwebtoken.Claims;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat").setAllowedOriginPatterns("*").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}

	/**
	 * adds user info (extracted from jwt) to the session info can be accessed by
	 * accessor.getUser()
	 */
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.interceptors(new ChannelInterceptor() {
			@Override
			public Message<?> preSend(Message<?> message, MessageChannel channel) {
				StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(
					message,
					StompHeaderAccessor.class
				);
				if (StompCommand.CONNECT.equals(accessor.getCommand())) {
					try {
						// this will throw a null pointer exception if the header is missing
						String authHeader = accessor.getNativeHeader(jwtUtil.getAuthorizationHeader()).get(0);
						String jwt = jwtUtil.extractToken(authHeader);

						if (jwt == null) {
							return null;
						}

						// parse token
						Claims claims = jwtUtil.extractClaims(jwt);
						// user
						JwtUserInfo user = jwtUtil.extractUserInfo(claims);
						// authorities List must be mapped tp Set
						Set<SimpleGrantedAuthority> authorities = jwtUtil.extractAuthorities(claims);
						// authenticate user
						Authentication authentication = new UsernamePasswordAuthenticationToken(
							user,
							null,
							authorities
						);
						// SecurityContextHolder.getContext().setAuthentication(authentication);
						accessor.setUser(authentication);
					} catch (Exception e) {
						System.out.println("ERROR: " + e);
						throw new IllegalStateException("token missing or cannot be trusted !!!");
					}

				}
				System.out.println("StompCommand: " + accessor.getCommand());
				return message;
			}
		});
	}

}
