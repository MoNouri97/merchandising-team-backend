package com.example.merchteam.report.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class BeforeAfter extends Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String imageBefore;
	private String imageAfter;
}
