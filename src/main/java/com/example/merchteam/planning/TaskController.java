package com.example.merchteam.planning;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.merchteam.appUser.AppUser;
import com.example.merchteam.category.Category;
import com.example.merchteam.competitor.Competitor;



@RestController
@CrossOrigin(origins = "*" /*"http://localhost:3000"*/)
@RequestMapping(path = "/api/v1/task")
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
	@GetMapping(value = "/{id}")
	public Task getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}
	@PostMapping
	public void addTask(@RequestBody Task task) {
		taskService.addTask(task);
	}
	@PutMapping("{id}")
	public void updateTaskById(
		@PathVariable("id") Long id,
		@RequestBody Map<String,String> body
	) {
		taskService.updateTaskById(id, body.get("state"));
	}
}
