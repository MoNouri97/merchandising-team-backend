package com.example.merchteam.appUser;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.merchteam.security.ApplicationUserRole;

import lombok.AllArgsConstructor;

@Entity
@Table
@AllArgsConstructor
public class Admin extends AppUser {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Admin(String password, String name, String email, String phone, LocalDate dob) {
		super(password, name, email, phone, ApplicationUserRole.ADMIN, dob);
	}

	public Admin(AppUser user) {
		super(
			user.getPassword(),
			user.getName(),
			user.getEmail(),
			user.getPhone(),
			ApplicationUserRole.MERCHANDISER,
			user.getDob()
		);
	}

}
