package com.example.merchteam.article;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.merchteam.category.Category;
import com.example.merchteam.gms.GMS;
import com.example.merchteam.report.event.model.Event;
import com.example.merchteam.report.event.model.Rupture;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
private String codeProduit;
private String prix;
private String poid;

@JsonIgnore
@ManyToMany(mappedBy = "articles", fetch = FetchType.LAZY)
private Set<GMS> gmsList = new HashSet<>();

@JsonIgnore
@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
private Set<Rupture> ruptures = new HashSet<>();

@JsonIgnore
@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
private Set<Event> events = new HashSet<>();

@ManyToOne
private Category category;

public Article() {
}

public Article(String designation, String reference, String type, String codeProduit, String prix, String poid,
		Set<GMS> gmsList, Category category) {
	super();
	this.designation = designation;
	this.reference = reference;
	this.type = type;
	this.codeProduit = codeProduit;
	this.prix = prix;
	this.poid = poid;
	this.gmsList = gmsList;
	this.category = category;
}

public Article(Long id, String designation, String reference, String type, String codeProduit, String prix, String poid,
		Set<GMS> gmsList, Category category) {
	super();
	this.id = id;
	this.designation = designation;
	this.reference = reference;
	this.type = type;
	this.codeProduit = codeProduit;
	this.prix = prix;
	this.poid = poid;
	this.gmsList = gmsList;
	this.category = category;
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

public Set<GMS> getGmsList() {
	return gmsList;
}

public void setGmsList(Set<GMS> gmsList) {
	this.gmsList = gmsList;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}




}
