package com.example.merchteam.report.event.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BeforeAfter extends Event {
	private String imageBefore;
	private String imageAfter;
}
