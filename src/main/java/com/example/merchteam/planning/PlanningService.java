package com.example.merchteam.planning;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlanningService {
	
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private PlanningRepository planningRepository;

	public List<Planning> getPlanning() {
		return planningRepository.findAll();
	}
	
	@Transactional
	public void addPlanning(Planning planning) {
		Planning pl =planningRepository.save(planning);
		var idList =planning.getTasks().stream().map(e -> e.getId()).collect(Collectors.toList());
		taskRepository.updateTasks(idList, pl.getId());
	}

	public Planning getPlanningPerMerchandiserId(Long merchandiserId) {	
		System.out.println("get action     "+merchandiserId);
		return planningRepository.findPlanningByMerchandiserId(merchandiserId).orElse(null);
	}
	@Transactional
	public void deleteByMerchandiser(Long id) {
		planningRepository.deletePlanningByMerchandiserId(id);
		
	}
	@Transactional
	public void updatePlanning(Long id, Planning planning) {
		planningRepository.deleteById(id);
		var p=planningRepository.save(planning);
		var idList =planning.getTasks().stream().map(e -> e.getId()).collect(Collectors.toList());
		taskRepository.updateTasks(idList, p.getId());
		
	}

}
