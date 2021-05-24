package com.example.merchteam.report.event.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class BeforeAfter extends Event {
	private String imageBefore;
	private String imageAfter;
}
