package com.example.merchteam.appUser;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.merchteam.security.ApplicationUserRole;

import lombok.AllArgsConstructor;

@Entity
@Table
@AllArgsConstructor
public class Merchandiser extends AppUser {
	/**
	 *
	 */
	private static final long serialVersionUID = -9031840772715357682L;

	public Merchandiser(String password, String name, String email, String phone, LocalDate dob) {
		super(password, name, email, phone, ApplicationUserRole.MERCHANDISER, dob);
	}

	public Merchandiser(AppUser user) {
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
