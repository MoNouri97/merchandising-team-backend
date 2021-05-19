package com.example.merchteam.appUser;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.merchteam.leaveRequest.LeaveRequest;
import com.example.merchteam.security.ApplicationUserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Admin extends AppUser {
	@JsonIgnore
	@OneToMany(mappedBy = "reviewer")
	private Set<LeaveRequest> reviewedLeaveRequests = new HashSet<>();

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
