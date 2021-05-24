package com.example.merchteam.report.event.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.example.merchteam.article.Article;
import com.example.merchteam.report.Report;
import com.example.merchteam.report.event.EventType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @JsonDeserialize(using = EventDeserializer.class)
@Getter
@Setter
@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "type",
	visible = true
)
@JsonSubTypes(
	{ @Type(value = Action.class, name = "Action"),
		@Type(value = BeforeAfter.class, name = "BeforeAfter"),
		@Type(value = CompetitorEvent.class, name = "CompetitorEvent"),
		@Type(value = NewProduct.class, name = "NewProduct"),
		@Type(value = PriceChange.class, name = "PriceChange"),
		@Type(value = ProductsVsCompetitor.class, name = "ProductsVsCompetitor"),
		@Type(value = Promotion.class, name = "Promotion"),
		@Type(value = Rupture.class, name = "Rupture") }
)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {
	@Id
	@SequenceGenerator(name = "event_sequence", sequenceName = "event_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_sequence")
	private Long id;

	@Enumerated(EnumType.STRING)
	private EventType type;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Article product;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Report report;
}