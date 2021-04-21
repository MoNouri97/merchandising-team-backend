package com.example.merchteam.model;

import com.example.merchteam.appUser.AppUser;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {
	private String token;
	private AppUser user;

	public AuthResponse(String token, AppUser user) {
		this.token = token;
		this.user = user;
	}

}
