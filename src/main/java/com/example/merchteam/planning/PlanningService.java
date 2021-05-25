package com.example.merchteam.planning;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlanningService {
	private final PlanningRepository planningRepository;
	@Autowired
	public PlanningService(PlanningRepository planningRepositor) {
		this.planningRepository = planningRepositor;
	}

	public List<Planning> getPlanning() {
		return planningRepository.findAll();
	}

	public void addPlanning(Planning planning) {
		planningRepository.save(planning);
		
	}

}
