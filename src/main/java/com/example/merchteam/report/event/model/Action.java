package com.example.merchteam.report.event.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Action extends Event {
	private String Title;

	@ElementCollection
	private Set<String> images = new HashSet<>();
}
