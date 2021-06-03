package com.example.merchteam.reclamation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/reclamation")
public class ReclamationController {
	private final ReclamationService reclamationservice;

	@Autowired
	public ReclamationController(ReclamationService service) {
		this.reclamationservice = service;
	}

	@GetMapping
	public List<Reclamation> getAllReclamations() {
		return reclamationservice.getAllReclamations();
	}

	@GetMapping(path = "{id}")
	public Reclamation getById(@PathVariable("id") Long id) {
		return reclamationservice.getById(id);
	}

	@PostMapping
	public Reclamation addReclamation(
		@RequestBody Reclamation body
	) {
		return reclamationservice.add(body);
	}

	@DeleteMapping(path = "{id}")
	public void deleteById(@PathVariable("id") Long id) {
		reclamationservice.delete(id);
	}

}
