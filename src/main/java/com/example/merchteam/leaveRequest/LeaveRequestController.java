package com.example.merchteam.leaveRequest;

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
@RequestMapping(path = "api/v1/leave")
public class LeaveRequestController {
	private final LeaveRequestService service;

	@Autowired
	public LeaveRequestController(LeaveRequestService service) {
		this.service = service;
	}

	@GetMapping
	public List<LeaveRequest> getAllLeaveRequests() {
		return service.getAll();
	}

	@GetMapping(path = "{id}")
	public LeaveRequest getById(@PathVariable("id") Long id) {
		return service.getById(id);
	}

	@PostMapping
	public LeaveRequest addLeaveRequest(@RequestBody LeaveRequest body) {
		return service.add(body);
	}

	@DeleteMapping(path = "{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
