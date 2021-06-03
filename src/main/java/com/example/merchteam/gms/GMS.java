package com.example.merchteam.gms;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.merchteam.article.Article;
import com.example.merchteam.category.Category;
import com.example.merchteam.competitor.Competitor;
import com.example.merchteam.planning.Task;
import com.example.merchteam.reclamation.Reclamation;
import com.example.merchteam.report.Report;
import com.example.merchteam.report.event.model.CompetitorEvent;
import com.example.merchteam.report.event.model.ProductsVsCompetitor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
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

@ManyToMany(fetch = FetchType.LAZY)
@JsonProperty(access = Access.WRITE_ONLY)
private Set<Article> articles = new HashSet<>();
@OneToMany(mappedBy = "gms")
@JsonIgnore
private Set<Reclamation> reclamations = new HashSet<>();
@JsonIgnore
@OneToMany(mappedBy = "gms")
private Set<Report> reports = new HashSet<>();

@OneToMany(fetch = FetchType.LAZY,
mappedBy = "gms")
@JsonIgnore
private Set<Task> tasks = new HashSet<>();


}
