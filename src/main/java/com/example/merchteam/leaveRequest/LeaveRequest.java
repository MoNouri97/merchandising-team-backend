package com.example.merchteam.leaveRequest;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private AppUser requester;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Admin reviewer;

	public LeaveRequest(
		LocalDate startDate,
		LocalDate endDate,
		String reason,
		AppUser requester,
		Admin reviewer
	) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.requester = requester;
		this.reviewer = reviewer;
	}

}
