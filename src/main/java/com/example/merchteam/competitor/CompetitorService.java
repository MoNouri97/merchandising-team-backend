package com.example.merchteam.competitor;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitorService {
	private final CompetitorRepository competitorRepository;

	@Autowired
	public CompetitorService(CompetitorRepository competitorRepository) {
		this.competitorRepository = competitorRepository;
	}

	public List<Competitor> getCompetitors() {
		return competitorRepository.findAll();
	}

	public Competitor getCompetitorParId(Long competitorId) {
		return competitorRepository.findById(competitorId)
			.orElseThrow(
				() -> new IllegalStateException("competitor with id" + competitorId + "does not exist")
			);

	}

	public void addCompetitor(Competitor competitor) {
		competitorRepository.save(competitor);
	}

	public void deleteCompetitor(Long competitorId) {
		boolean exists = competitorRepository.existsById(competitorId);
		if (!exists) {
			throw new IllegalStateException("competitor with id" + competitorId + "does not exist");
		}
		competitorRepository.deleteById(competitorId);
	}

	public Competitor updateCompetitor(Long competitorId, Competitor crt) {
		return competitorRepository.findById(competitorId).map(competitor -> {
			if (
				crt.getName() != null && crt.getName().length() > 0
					&& !Objects.equals(competitor.getName(), crt.getName())
			) {
				competitor.setName(crt.getName());
			}
			 
			
			return competitorRepository.save(competitor);
		})
			.orElseThrow(
				() -> new IllegalStateException("competitor with id" + competitorId + "does not exist")
			);

	}

}
