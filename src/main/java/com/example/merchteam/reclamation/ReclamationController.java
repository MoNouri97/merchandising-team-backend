package com.example.merchteam.reclamation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
