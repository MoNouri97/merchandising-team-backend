package com.example.merchteam.report.event.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.example.merchteam.competitor.Competitor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductsVsCompetitor extends Event {

	@ManyToOne(cascade = CascadeType.MERGE)
	private Competitor competitor;

	private String imageCompetitor;
	private String imageProduct;
}
