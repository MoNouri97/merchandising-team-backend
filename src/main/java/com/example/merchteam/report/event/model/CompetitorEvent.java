package com.example.merchteam.report.event.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CompetitorEvent extends Event {

	@ElementCollection
	private Set<String> images = new HashSet<>();
	// FIXME:competitor
}
