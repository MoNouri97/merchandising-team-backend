package com.example.merchteam.planning;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.merchteam.competitor.Competitor;



@RestController
@CrossOrigin(origins = "*" /*"http://localhost:3000"*/)
@RequestMapping(path = "/api/v1/planning")
public class TaskController {
	private final TaskService taskService;
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	@GetMapping
	public List<Task> getTasks() {
		return  taskService.getTasks();
	}
	@PostMapping
	public void addTask(@RequestBody Task task) {
		taskService.addTask(task);
	}
}
