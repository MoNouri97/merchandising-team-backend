package com.example.merchteam.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {
	private String token;
	private String userName;
	private Date timestamp;

	public AuthResponse(String token, String userName) {
		this.token = token;
		this.userName = userName;
		this.timestamp = new Date();
	}

}
