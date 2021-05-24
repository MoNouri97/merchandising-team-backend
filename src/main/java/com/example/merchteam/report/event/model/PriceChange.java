package com.example.merchteam.report.event.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PriceChange extends Event {
	private Double oldPrice;
	private Double newPrice;
}
