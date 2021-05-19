package com.example.merchteam.reclamation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationService {
	private final ReclamationRepository repository;

	@Autowired
	public ReclamationService(ReclamationRepository reclamationRepository) {
		this.repository = reclamationRepository;
	}
	public List<Reclamation> getAllReclamations() {
		return repository.findAll();
	}

	public Reclamation getById(Long id) {
		return repository.findById(id)
			.orElseThrow(() -> new IllegalStateException("Reclamation with id" + id + "does not exist"));
	}

	public Reclamation add(Reclamation body) {
		return repository.save(body);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
