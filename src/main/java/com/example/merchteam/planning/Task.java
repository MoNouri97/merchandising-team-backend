package com.example.merchteam.planning;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.merchteam.gms.GMS;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
private LocalDateTime endDate;//end is actually a reserved word in postgres sql 
private String name;
@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
private LocalDateTime start;

private int duration;

//cascade =  CascadeType.ALL,
//optional = false
		
//@JoinColumn(name = "gms_id"/*, nullable = false*/)
@OneToOne
private GMS gms;
/*@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="merchandiserID")
private Merchandiser merchandiser;*/

// @ManyToOne
// @JoinColumn(name="merchandiser_id"/*, nullable=false*/)
// private Merchandiser merchandiser;
public Task() {
	super();
}
public Task(String name, LocalDateTime start,LocalDateTime endDate, int duration) {
	super();
	this.name = name;
	this.start = start;
	this.endDate=endDate;
	this.duration = duration;
}

public Task(Long id, String name, LocalDateTime start, LocalDateTime endDate, int duration) {
	super();
	this.id = id;
	this.name = name;
	this.start = start;
	this.endDate=endDate;
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
public LocalDateTime getStart() {
	return start;
}
public void setStart(LocalDateTime date) {
	this.start = date;
}
public LocalDateTime getEndDate() {
	return endDate;
}
public void setEndDate(LocalDateTime endDate) {
	this.endDate = endDate;
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
