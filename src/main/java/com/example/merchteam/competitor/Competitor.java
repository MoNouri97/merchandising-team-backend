package com.example.merchteam.competitor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.merchteam.category.Category;
import com.example.merchteam.claimType.ClaimType;
import com.example.merchteam.gms.GMS;
import com.example.merchteam.reclamation.Reclamation;
import com.example.merchteam.report.event.model.CompetitorEvent;
import com.example.merchteam.report.event.model.ProductsVsCompetitor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table
public class Competitor {
	@Id
	@SequenceGenerator(
		name = "concurrent_sequence",
		sequenceName = "concurrent_sequence",
		allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "concurrent_sequence")
	private Long id;
	private String name;
	
	
	@OneToMany(mappedBy = "competitor")
	private Set<CompetitorEvent> competitorEvents = new HashSet<>();
	@OneToMany(mappedBy = "competitor")
	private Set<ProductsVsCompetitor> vsCompetitors = new HashSet<>();

}
