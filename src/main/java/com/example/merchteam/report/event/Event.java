package com.example.merchteam.report.event;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import com.example.merchteam.article.Article;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Event {
	@Id
	@SequenceGenerator(name = "event_sequence", sequenceName = "event_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_sequence")
	private Long id;

	@Enumerated(EnumType.STRING)
	private EventType type;

	private Article product;
}
