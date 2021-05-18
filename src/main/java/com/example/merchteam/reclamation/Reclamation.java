package com.example.merchteam.reclamation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Reclamation {
	@Id
	@SequenceGenerator(
		name = "reclamation_sequence",
		sequenceName = "reclamation_sequence",
		allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reclamation_sequence")
	private Long id;
	private String name;
	private String gms;
	private String merchandiser;
	public Reclamation() {
		super();
	}
	public Reclamation(String name, String gms, String merchandiser) {
		super();
		this.name = name;
		this.gms = gms;
		this.merchandiser = merchandiser;
	}
	public Reclamation(Long id, String name, String gms, String merchandiser) {
		super();
		this.id = id;
		this.name = name;
		this.gms = gms;
		this.merchandiser = merchandiser;
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
	public String getGms() {
		return gms;
	}
	public void setGms(String gms) {
		this.gms = gms;
	}
	public String getMerchandiser() {
		return merchandiser;
	}
	public void setMerchandiser(String merchandiser) {
		this.merchandiser = merchandiser;
	}
	
	
}
