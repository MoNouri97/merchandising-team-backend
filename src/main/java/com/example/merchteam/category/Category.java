package com.example.merchteam.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.merchteam.article.Article;
import com.example.merchteam.chat.ChatMessage;
import com.example.merchteam.competitor.Competitor;
import com.example.merchteam.gms.GMS;
import com.example.merchteam.planning.Task;
import com.example.merchteam.reclamation.Reclamation;
import com.example.merchteam.report.Report;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table
public class Category {
	@Id
	@SequenceGenerator(
		name = "categorie_sequence",
		sequenceName = "categorie_sequence",
		allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorie_sequence")
	private Long id;
	private String nom;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private Set<Article> articles = new HashSet<>();
	

}
