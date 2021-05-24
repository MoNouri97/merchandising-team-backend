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
import com.example.merchteam.gms.GMS;
import com.example.merchteam.report.event.model.CompetitorEvent;
import com.example.merchteam.report.event.model.ProductsVsCompetitor;

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
	
	
	@ManyToMany
	@JoinTable(
			name="competitors_per_gms"
			)
	private Set<GMS> gms = new HashSet<>();
	
	@ManyToMany
	@JoinTable(
			name="competitors_per_category"
			)
	private Set<Category> categories = new HashSet<>();
	
	
	@OneToMany(mappedBy = "competitor")
	private Set<CompetitorEvent> competitorEvents = new HashSet<>();
	@OneToMany(mappedBy = "competitor")
	private Set<ProductsVsCompetitor> vsCompetitors = new HashSet<>();

	public Competitor() {
		super();
	}

	public Competitor(String name, Set<GMS> gms, Set<Category> categories) {
		super();
		this.name = name;
		this.gms = gms;
		this.categories = categories;
	}

	public Competitor(Long id, String name, Set<GMS> gms, Set<Category> categories) {
		super();
		this.id = id;
		this.name = name;
		this.gms = gms;
		this.categories = categories;
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

	public Set<GMS> getGms() {
		return gms;
	}

	public void setGms(Set<GMS> gms) {
		this.gms = gms;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	

}
