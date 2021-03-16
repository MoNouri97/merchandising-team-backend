package com.example.merchteam.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ApplicationUserRole {
	MERCHANDISER, ADMIN, SUPERVISOR;

	public List<SimpleGrantedAuthority> grantedAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + this.name()));
	}
}
