package com.example.merchteam.planning;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*" /*"http://localhost:3000"*/)
@RequestMapping(path = "/api/v1/taskPlanning")
public class PlanningController {
private final PlanningService planningService;
@Autowired
public PlanningController(PlanningService planningService) {
	this.planningService=planningService;
}
@GetMapping
public List<Planning> getPlanning() {
	return  planningService.getPlanning();
}
@GetMapping(path = "merchandiser/{id}")
public Planning getPlanningPerMerchandiserId(@PathVariable("id") Long id) {
	return  planningService.getPlanningPerMerchandiserId(id);
}
@PostMapping
public void addPlanning(@RequestBody Planning planning) {
	planningService.addPlanning(planning);
}
}
