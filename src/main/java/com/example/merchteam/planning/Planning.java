package com.example.merchteam.planning;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Planning {
	private static final long serialVersionUID = 5167365018624987876L;
	@Id
	@SequenceGenerator(
			name="planning_sequence",
			sequenceName="task_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy =GenerationType.SEQUENCE,
			generator="planning_sequence"
	)
private Long id;
@JsonFormat(pattern = "yyyy-MM-dd")
private LocalDate startDate;
@JsonFormat(pattern = "yyyy-MM-dd")
private LocalDate endDate;
@OneToMany(mappedBy = "planning")
private List<Task> tasks=new ArrayList<>();
public Planning() {
	super();
}
public Planning(LocalDate startDate, LocalDate endDate, List<Task> tasks) {
	super();
	this.startDate = startDate;
	this.endDate = endDate;
	this.tasks = tasks;
}
public Planning(Long id, LocalDate startDate, LocalDate endDate, List<Task> tasks) {
	super();
	this.id = id;
	this.startDate = startDate;
	this.endDate = endDate;
	this.tasks = tasks;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public LocalDate getStartDate() {
	return startDate;
}
public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}
public LocalDate getEndDate() {
	return endDate;
}
public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}
public List<Task> getTasks() {
	return tasks;
}
public void setTasks(List<Task> tasks) {
	this.tasks = tasks;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}


}
