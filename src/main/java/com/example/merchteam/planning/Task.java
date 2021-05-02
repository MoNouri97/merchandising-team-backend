package com.example.merchteam.planning;

import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.merchteam.appUser.AppUser;
import com.example.merchteam.appUser.Merchandiser;
import com.example.merchteam.gms.GMS;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
private String name;
@JsonFormat(pattern = "dd-MM-yyyy")
private LocalDate date;
private int duration;
@OneToOne(
cascade =  CascadeType.ALL/*,
optional = false*/)
@JoinColumn(name = "gms_id"/*, nullable = false*/)
private GMS gms;

/*@ManyToOne
@JoinColumn(name="merchandiser_id", nullable=false)
private Merchandiser merchandiser;*/
public Task() {
	super();
}
public Task(String name, LocalDate date, int duration) {
	super();
	this.name = name;
	this.date = date;
	this.duration = duration;
}
public Task(Long id, String name, LocalDate date, int duration) {
	super();
	this.id = id;
	this.name = name;
	this.date = date;
	this.duration = duration;
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
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public GMS getGms() {
	return gms;
}
public void setGms(GMS gms) {
	this.gms = gms;
}

}
