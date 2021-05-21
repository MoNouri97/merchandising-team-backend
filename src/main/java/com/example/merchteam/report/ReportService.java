package com.example.merchteam.report;

import java.util.List;

import com.example.merchteam.report.event.EventRepository;
import com.example.merchteam.report.event.model.Action;
import com.example.merchteam.report.event.model.BeforeAfter;
import com.example.merchteam.report.event.model.CompetitorEvent;
import com.example.merchteam.report.event.model.NewProduct;
import com.example.merchteam.report.event.model.PriceChange;
import com.example.merchteam.report.event.model.ProductsVsCompetitor;
import com.example.merchteam.report.event.model.Promotion;
import com.example.merchteam.report.event.model.Rupture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
	@Autowired
	private EventRepository<Action> actionRepo;
	@Autowired
	private EventRepository<BeforeAfter> BeforeAfterRepo;
	@Autowired
	private EventRepository<CompetitorEvent> CompetitorEventRepo;
	@Autowired
	private EventRepository<NewProduct> NewProductRepo;
	@Autowired
	private EventRepository<PriceChange> PriceChangeRepo;
	@Autowired
	private EventRepository<ProductsVsCompetitor> ProductsVsCompetitorRepo;
	@Autowired
	private EventRepository<Promotion> PromotionRepo;
	@Autowired
	private EventRepository<Rupture> RuptureRepo;

	public List<Report> getAll() {
		return null;
	}

	public Report getOne(Long id) {
		return null;
	}

	public Report create(Report report) {
		return null;
	}
}
