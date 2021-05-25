package com.example.merchteam.competitor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*" /* "http://localhost:3000" */)
@RequestMapping(path = "/api/v1/competitor")
public class CompetitorController {
	private final CompetitorService service;

	@Autowired
	public CompetitorController(CompetitorService service) {
		this.service = service;
	}

	@GetMapping
	public List<Competitor> getCompetitors() {
		return service.getCompetitors();
	}
	@GetMapping(path = "{competitorId}")
	public Competitor getCompetitorParId(@PathVariable("competitorId") Long competitorId) {
		return service.getCompetitorParId(competitorId);
	}

	@PostMapping
	public void addCompetitor(@RequestBody Competitor competitor) {
		service.addCompetitor(competitor);
	}

	@DeleteMapping(path = "{competitorId}")
	public void deleteCompetitor(@PathVariable("competitorId") Long competitorId) {
		service.deleteCompetitor(competitorId);
	}

	@PutMapping("{competitorId}")
	public void updateCompetitor(
		@PathVariable("competitorId") Long competitorId,
		@RequestBody Competitor competitor
	) {
		service.updateCompetitor(competitorId, competitor);
	}
}
