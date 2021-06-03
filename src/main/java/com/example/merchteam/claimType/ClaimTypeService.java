package com.example.merchteam.claimType;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimTypeService {
	private final ClaimTypeRepository repository;

	@Autowired
	public ClaimTypeService(ClaimTypeRepository claimtypeRepository) {
		this.repository = claimtypeRepository;
	}

	public List<ClaimType> getAllClaimTypes() {
		return repository.findAll();
	}

	public ClaimType getById(Long id) {
		return repository.findById(id)
			.orElseThrow(() -> new IllegalStateException("ClaimType with id" + id + "does not exist"));
	}

	public ClaimType add(ClaimType body) {
		return repository.save(body);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public ClaimType updateClaimType(Long id, ClaimType claimType) {
		return repository.findById(id).map(claimTypeTokenvariable -> {
			if (
					claimType.getName() != null && claimType.getName().length() > 0
					&& !Objects.equals(claimTypeTokenvariable.getName(), claimType.getName())
			) {
				claimTypeTokenvariable.setName(claimType.getName());
			}
			return repository.save(claimTypeTokenvariable);
		})
			.orElseThrow(
				() -> new IllegalStateException("claim type with id" + id + "does not exist")
			);
		
	}

}
