package com.example.merchteam.report.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PriceChange extends Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Double oldPrice;
	private Double newPrice;
}
