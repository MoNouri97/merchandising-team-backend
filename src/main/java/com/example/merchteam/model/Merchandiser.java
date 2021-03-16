package com.example.merchteam.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.merchteam.security.ApplicationUserRole;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
public class Merchandiser extends AppUser {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Merchandiser(String password, String name, String email, String phone, LocalDate dob) {
		super(password, name, email, phone, ApplicationUserRole.MERCHANDISER, dob);
	}

}
