package com.example.merchteam.leaveRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveRequestService {
	@Autowired
	private LeaveRequestRepository repository;

	public List<LeaveRequest> getAll() {
		return repository.findAll();
	}

	public LeaveRequest getById(Long id) {
		return repository.findById(id)
			.orElseThrow(() -> new IllegalStateException("LeaveRequest with id" + id + "does not exist"));
	}

	public LeaveRequest add(LeaveRequest body) {
		return repository.save(body);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
