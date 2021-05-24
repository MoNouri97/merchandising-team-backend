package com.example.merchteam.report;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.example.merchteam.report.event.model.Event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Report {
	@Id
	@SequenceGenerator(name = "report_sequence", sequenceName = "report_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_sequence")
	private Long id;

	private LocalDateTime dateTime;
	private Boolean valid;
	private Double longitude;
	private Double latitude;

	@OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
	private Set<Event> events = new HashSet<>();

	public Report(
		LocalDateTime dateTime,
		Boolean valid,
		Double longitude,
		Double latitude,
		Set<Event> events
	) {
		this.dateTime = dateTime;
		this.valid = valid;
		this.longitude = longitude;
		this.latitude = latitude;
		this.events = events;
	}
}
