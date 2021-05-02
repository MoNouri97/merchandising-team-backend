package com.example.merchteam.gms;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.merchteam.article.Article;
import com.example.merchteam.planning.Task;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "gms")
public class GMS implements Serializable {
	@Id
	@SequenceGenerator(
			name="gms_sequence",
			sequenceName="gms_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy =GenerationType.SEQUENCE,
			generator="gms_sequence"
	)
	@Column(name = "id")
private Long id;
private String name;
private String image;
private int estimatedTime;
private double longitude;
private double latitude;

@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
private Set<Article> articles = new HashSet<>();

@OneToOne(fetch = FetchType.LAZY,
cascade =  CascadeType.ALL,
mappedBy = "gms")
@JsonIgnoreProperties("gms")
private Task task;
public GMS() {
	super();
}
public GMS(String name, String image, int estimatedTime, double longitude, double latitude) {
	super();
	this.name = name;
	this.image = image;
	this.estimatedTime = estimatedTime;
	this.longitude = longitude;
	this.latitude = latitude;
}

public GMS(Long id, String name, String image, int estimatedTime, Long longitude, Long latitude) {
	super();
	this.id = id;
	this.name = name;
	this.image = image;
	this.estimatedTime = estimatedTime;
	this.longitude = longitude;
	this.latitude = latitude;
}

public Set<Article> getArticles() {
	return articles;
}

public void setArticles(Set<Article> articles) {
	this.articles = articles;
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
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getEstimatedTime() {
	return estimatedTime;
}
public void setEstimatedTime(int estimatedTime) {
	this.estimatedTime = estimatedTime;
}
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public Task getTask() {
	return task;
}
public void setTask(Task task) {
	this.task = task;
}


}
