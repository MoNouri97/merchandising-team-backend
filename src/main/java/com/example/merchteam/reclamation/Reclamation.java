package com.example.merchteam.reclamation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.example.merchteam.appUser.AppUser;
import com.example.merchteam.claimType.ClaimType;
import com.example.merchteam.gms.GMS;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Reclamation {
	@Id
	@SequenceGenerator(
		name = "reclamation_sequence",
		sequenceName = "reclamation_sequence",
		allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reclamation_sequence")
	private Long id;
	private String content;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private GMS gms;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private AppUser merchandiser;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private ClaimType type;

	public Reclamation(String content, GMS gms, AppUser merchandiser, ClaimType type) {
		this.content = content;
		this.gms = gms;
		this.merchandiser = merchandiser;
		this.type = type;
	}
	
	
}
