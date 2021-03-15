package com.example.merchteam.util;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
@ConfigurationProperties(prefix = "app.jwt")
public class JwtUtil {
	private String secretKey;
	private String tokenPrefix;
	private Integer tokenExpirationDays;

	public JwtUtil() {
	}

	public SecretKey getJwtSecret() {
		return Keys.hmacShaKeyFor(secretKey.getBytes());
	}

	public String getAuthorizationHeader() {
		return HttpHeaders.AUTHORIZATION;
	}

	public String extractToken(String authHeader) {
		if (Strings.isNullOrEmpty(authHeader) || !authHeader.startsWith(tokenPrefix)) {
			return null;
		}
		return authHeader.replace(tokenPrefix, "");
	}

	public Claims extractClaims(String token) {
		// parse token
		Jws<Claims> parsedClaimsJws = Jwts.parserBuilder().setSigningKey(getJwtSecret()).build().parseClaimsJws(token);
		return parsedClaimsJws.getBody();
	}

	public String extractUsername(String token) {
		Claims claims = extractClaims(token);
		return claims.getSubject();
	}

	public String extractUsername(Claims claims) {
		return claims.getSubject();
	}

	public Object extractClaim(Claims claims, String claim) {
		return claims.get(claim);
	}

	public Set<SimpleGrantedAuthority> extractAuthorities(Claims claims) {
		// authorities List must be mapped tp Set
		var authorities = (Collection<Map<String, String>>) extractClaim(claims, "authorities");
		return authorities.stream().map(m -> new SimpleGrantedAuthority(m.get("authority"))).collect(Collectors.toSet());
	}

	public Boolean IsTokenExpired(Claims claims) {
		return claims.getExpiration().before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		Claims claims = extractClaims(token);
		return (extractUsername(claims).equals(userDetails.getUsername()) && !IsTokenExpired(claims));
	}

	public String generateToken(String username, Map<String, Object> claims) {
		// build token
		return Jwts.builder()
			.setSubject(username)
			.setClaims(claims)
			.setIssuedAt(new java.util.Date())
			.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(tokenExpirationDays)))
			.signWith(getJwtSecret())
			.compact();
	}

	public String generateAuthHeader(String username, Map<String, Object> claims) {
		return tokenPrefix + generateToken(username, claims);
	}

}
