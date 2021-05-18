package com.example.merchteam.reclamation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationService {
	private final ReclamationRepository reclamationRepository;

	@Autowired
	public ReclamationService(ReclamationRepository reclamationRepository) {
		this.reclamationRepository = reclamationRepository;
	}
	public List<Reclamation> getAllReclamations() {
		return reclamationRepository.findAll();
	}

}
