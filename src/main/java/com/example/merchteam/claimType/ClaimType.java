package com.example.merchteam.claimType;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.example.merchteam.reclamation.Reclamation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ClaimType {
	@Id
	@SequenceGenerator(
		name = "claimtype_sequence",
		sequenceName = "claimtype_sequence",
		allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "claimtype_sequence")
	private Long id;
	private String name;
	@JsonIgnore
	@OneToMany(mappedBy = "type")
	private Set<Reclamation> reclamations = new HashSet<>();

}
