package com.example.merchteam.report.event.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CompetitorEvent extends Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	private Set<String> images = new HashSet<>();
}
