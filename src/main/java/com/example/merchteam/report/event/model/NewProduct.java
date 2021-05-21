package com.example.merchteam.report.event.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class NewProduct extends Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String imageProduct;
}
