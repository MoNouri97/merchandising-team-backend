package com.example.merchteam.report.event.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.example.merchteam.article.Article;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Rupture extends Event {

	private Boolean purchaseOrder;
	private String image;

	@ManyToMany(cascade = CascadeType.MERGE)
	private Set<Article> products = new HashSet<>();
}
