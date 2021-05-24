package com.example.merchteam.report.event.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Rupture extends Event {

	private Boolean purchaseOrder;
	private String image;

	// FIXME : multi products
}
