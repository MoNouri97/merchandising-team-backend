package com.example.merchteam.report.event.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.example.merchteam.competitor.Competitor;

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

	@ManyToOne(cascade = CascadeType.MERGE)
	Competitor competitor;
}
