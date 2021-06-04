package com.example.merchteam.leaveRequest;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.example.merchteam.appUser.Admin;
import com.example.merchteam.appUser.AppUser;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class LeaveRequest {
	@Id
	@SequenceGenerator(
		name = "leave_sequence",
		sequenceName = "leave_sequence",
		allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_sequence")
	private Long id;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate endDate;
	private String reason;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private AppUser requester;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Admin reviewer;

	@Enumerated(EnumType.STRING)
	private LeaveRequestState state = LeaveRequestState.WAITING;

	public enum LeaveRequestState {
		ACCEPTED, REFUSED, WAITING
	}

}
