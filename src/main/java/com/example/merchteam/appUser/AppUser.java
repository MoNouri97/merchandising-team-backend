package com.example.merchteam.appUser;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.example.merchteam.chat.ChatMessage;
import com.example.merchteam.leaveRequest.LeaveRequest;
import com.example.merchteam.reclamation.Reclamation;
import com.example.merchteam.security.ApplicationUserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// @MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AppUser implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String password;
	private String name;

	@Column(unique = true)
	private String email;
	private String phone;
	@Enumerated(EnumType.STRING)
	private ApplicationUserRole role;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dob;

	@JsonIgnore
	@OneToMany(mappedBy = "sender")
	private Set<ChatMessage> sentChat = new HashSet<>();
	@JsonIgnore
	@OneToMany(mappedBy = "receiver")
	private Set<ChatMessage> receivedChat = new HashSet<>();
	@JsonIgnore
	@OneToMany(mappedBy = "merchandiser")
	private Set<Reclamation> reclamations = new HashSet<>();
	@JsonIgnore
	@OneToMany(mappedBy = "requester")
	private Set<LeaveRequest> leaveRequests = new HashSet<>();

	public AppUser(
		String password,
		String name,
		String email,
		String phone,
		ApplicationUserRole role,
		LocalDate dob
	) {
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.dob = dob;
	}

	// #region getters & setters
	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ApplicationUserRole getRole() {
		return role;
	}

	public void setRole(ApplicationUserRole role) {
		this.role = role;
	}

	// #endregion

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role.grantedAuthorities();
	}

	@Override
	public String getUsername() {
		return email;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Long getId() {
		return id;
	}

}
