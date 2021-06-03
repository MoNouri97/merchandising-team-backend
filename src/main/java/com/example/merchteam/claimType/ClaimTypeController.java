package com.example.merchteam.claimType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.merchteam.category.Category;

@RestController
@RequestMapping(path = "api/v1/claimtype")
public class ClaimTypeController {
	private final ClaimTypeService service;

	@Autowired
	public ClaimTypeController(ClaimTypeService service) {
		this.service = service;
	}

	@GetMapping
	public List<ClaimType> getAllClaimTypes() {
		return service.getAllClaimTypes();
	}

	@GetMapping(path = "{id}")
	public ClaimType getById(@PathVariable("id") Long id) {
		return service.getById(id);
	}

	@PostMapping
	public ClaimType addClaimType(@RequestBody ClaimType body) {
		return service.add(body);
	}

	@DeleteMapping(path = "{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.delete(id);
	}
	@PutMapping("{id}")
	public void updateClaimType(
		@PathVariable("id") Long id,
		@RequestBody ClaimType claimType
	) {
		service.updateClaimType(id, claimType);
	}

}
