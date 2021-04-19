package com.example.merchteam.article;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table
public class Article {
	@Id
	@SequenceGenerator(
			name="article_sequence",
			sequenceName="article_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy =GenerationType.SEQUENCE,
			generator="article_sequence"
	)
private Long id;
private String designation;
private String reference;
private String type;
private String categorie;
private String codeProduit;
private String prix;
private String poid;
public Article() {
}
public Article(Long id, String designation, String reference, String type, String codeProduit,
		String prix, String poid,String categorie) {
	this.id = id;
	this.designation = designation;
	this.reference = reference;
	this.type = type;
	this.codeProduit = codeProduit;
	this.prix = prix;
	this.poid = poid;
	this.categorie=categorie;
}
public Article(String designation, String reference, String type, String codeProduit, String prix, String poid,String categorie) {
	this.designation = designation;
	this.reference = reference;
	this.type = type;
	this.codeProduit = codeProduit;
	this.prix = prix;
	this.poid = poid;
	this.categorie=categorie;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCodeProduit() {
	return codeProduit;
}
public void setCodeProduit(String codeProduit) {
	this.codeProduit = codeProduit;
}
public String getPrix() {
	return prix;
}
public void setPrix(String prix) {
	this.prix = prix;
}
public String getPoid() {
	return poid;
}
public void setPoid(String poid) {
	this.poid = poid;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}



}