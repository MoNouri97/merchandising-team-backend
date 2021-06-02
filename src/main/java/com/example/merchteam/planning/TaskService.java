package com.example.merchteam.planning;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.merchteam.appUser.AppUser;
@Service
public class TaskService {
	private final TaskRepository taskRepository;
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}
	public void addTask(Task task) {
		taskRepository.save(task);
		
	}
	public Task getTaskById(Long id) {
		return taskRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Task with id " + id + " does not exist"));
	}
	
}
