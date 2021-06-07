package com.example.merchteam.leaveRequest;

import java.util.List;
import java.util.Objects;

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

	public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest) {
		return repository.findById(id).map(leaveRequestTokenvariable -> {
			 
				leaveRequestTokenvariable.setState(leaveRequest.getState());
			
			return repository.save(leaveRequestTokenvariable);
		})
			.orElseThrow(
				() -> new IllegalStateException("leave request with id" + id + "does not exist")
			);
		
	}

}
