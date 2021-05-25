package com.example.merchteam.planning;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.merchteam.appUser.Merchandiser;
import com.example.merchteam.gms.GMS;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table
public class Task implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5167365018624987876L;
	@Id
	@SequenceGenerator(
			name="task_sequence",
			sequenceName="task_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy =GenerationType.SEQUENCE,
			generator="task_sequence"
	)
private Long id;
private int day;
private String state;

@OneToOne(fetch = FetchType.LAZY,
cascade =  CascadeType.ALL)
private GMS gms;


@ManyToOne
private Merchandiser merchandiser;
@JsonIgnore
@ManyToOne
private Planning planning;

public Task() {
	super();
}

public Task(int day, String state, GMS gms, Merchandiser merchandiser, Planning planning) {
	super();
	this.day = day;
	this.state = state;
	this.gms = gms;
	this.merchandiser = merchandiser;
	this.planning = planning;
}

public Task(Long id, int day, String state, GMS gms, Merchandiser merchandiser, Planning planning) {
	super();
	this.id = id;
	this.day = day;
	this.state = state;
	this.gms = gms;
	this.merchandiser = merchandiser;
	this.planning = planning;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public GMS getGms() {
	return gms;
}

public void setGms(GMS gms) {
	this.gms = gms;
}

public Merchandiser getMerchandiser() {
	return merchandiser;
}

public void setMerchandiser(Merchandiser merchandiser) {
	this.merchandiser = merchandiser;
}

public Planning getPlanning() {
	return planning;
}

public void setPlanning(Planning planning) {
	this.planning = planning;
}






}
