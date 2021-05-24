package com.example.merchteam.report.event.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Promotion extends Event {

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate endDate;

	private Double oldPrice;
	private Double newPrice;

	@ElementCollection
	private Set<String> images = new HashSet<>();
}
