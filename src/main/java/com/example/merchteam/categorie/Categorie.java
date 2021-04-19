package com.example.merchteam.categorie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Categorie {
	@Id
	@SequenceGenerator(
			name="categorie_sequence",
			sequenceName="categorie_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy =GenerationType.SEQUENCE,
			generator="categorie_sequence"
	)
private Long id;
private String nom;
public Categorie() {
}
public Categorie(Long id, String nom) {
	this.id = id;
	this.nom = nom;
}
public Categorie(String nom) {
	this.nom = nom;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}



}
