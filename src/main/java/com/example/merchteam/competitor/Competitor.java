package com.example.merchteam.competitor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Competitor {
	@Id
	@SequenceGenerator(
		name = "concurrent_sequence",
		sequenceName = "concurrent_sequence",
		allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "concurrent_sequence")
	private Long id;
	private String name;
	private String category;
	private String gms;

	public Competitor() {
		super();
	}

	public Competitor(String name, String category, String gms) {
		super();
		this.name = name;
		this.category = category;
		this.gms = gms;
	}

	public Competitor(Long id, String name, String category, String gms) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.gms = gms;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGms() {
		return gms;
	}

	public void setGms(String gms) {
		this.gms = gms;
	}

}
