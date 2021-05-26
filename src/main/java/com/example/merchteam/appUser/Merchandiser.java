package com.example.merchteam.appUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.merchteam.article.Article;
import com.example.merchteam.planning.Planning;
import com.example.merchteam.planning.Task;
import com.example.merchteam.security.ApplicationUserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;

@Entity
@Table
@AllArgsConstructor
public class Merchandiser extends AppUser {
	/**
	 *
	 */
	private static final long serialVersionUID = -9031840772715357682L;
	
	@OneToOne(fetch = FetchType.LAZY,
			mappedBy = "merchandiser")
			@JsonIgnore
			private Planning planning;


	public Merchandiser(String password, String name, String email, String phone, LocalDate dob) {
		super(password, name, email, phone, ApplicationUserRole.MERCHANDISER, dob);
	}
	public Merchandiser() {
		super();
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


	public Merchandiser(String password, String name, String email, String phone, ApplicationUserRole role,
			LocalDate dob) {
		super(password, name, email, phone, role, dob);
	}
	public Planning getPlanning() {
		return planning;
	}
	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	

}
