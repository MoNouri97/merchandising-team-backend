package com.example.merchteam.planning;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.merchteam.appUser.Merchandiser;
import com.example.merchteam.gms.GMS;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
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
@JsonFormat(pattern = "dd-MM-yyyy")
private LocalDate startDate;
@JsonFormat(pattern = "dd-MM-yyyy")
private LocalDate endDate;
@OneToMany(mappedBy = "planning",cascade = {CascadeType.ALL})
private List<Task> tasks=new ArrayList<>();
@OneToOne(fetch = FetchType.EAGER,
cascade =  CascadeType.MERGE)
private Merchandiser merchandiser;



}
