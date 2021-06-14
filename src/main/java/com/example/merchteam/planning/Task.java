package com.example.merchteam.planning;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

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
import com.example.merchteam.claimType.ClaimType;
import com.example.merchteam.gms.GMS;
import com.example.merchteam.reclamation.Reclamation;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
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
@JsonFormat(pattern = "dd-MM-yyyy")
private LocalDate taskDate;
private String state;

@ManyToOne(fetch = FetchType.EAGER
/*cascade =  CascadeType.MERGE*/)
private GMS gms;



@JsonIgnore
@ManyToOne
private Planning planning;

}
