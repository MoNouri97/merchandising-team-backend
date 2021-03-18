package com.example.merchteam.controller;

import java.util.List;

import com.example.merchteam.model.Admin;
import com.example.merchteam.model.AppUser;
import com.example.merchteam.model.Merchandiser;
import com.example.merchteam.model.Supervisor;
import com.example.merchteam.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class AppUserController {

	@Autowired
	private AppUserService<AppUser> userService;
	@Autowired
	private AppUserService<Admin> adminService;
	@Autowired
	private AppUserService<Merchandiser> merchandiserService;
	@Autowired
	private AppUserService<Supervisor> supervisorService;

	@GetMapping()
	public List<AppUser> getAllUsers() {
		return userService.getAppUsers();
	}

	@PostMapping()
	public AppUser addUser(@RequestBody AppUser user) {
		switch (user.getRole()) {
		case ADMIN:
			return adminService.addAppUser(new Admin(user));
		case SUPERVISOR:
			return supervisorService.addAppUser(new Supervisor(user));
		case MERCHANDISER:
		default:
			return merchandiserService.addAppUser(new Merchandiser(user));
		}
	}

	@PutMapping(value = "/{id}")
	public AppUser updateUser(@PathVariable Long id, @RequestBody AppUser user) {
		return userService.updateAppUser(id, user);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> requestMethodName(@PathVariable Long id) {

		userService.deleteAppUser(id);
		return ResponseEntity.ok("User " + id + " deleted");
	}

}
