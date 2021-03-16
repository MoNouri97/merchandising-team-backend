package com.example.merchteam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.merchteam.model.AppUser;
import com.example.merchteam.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService<T extends AppUser> implements UserDetailsService {

	private final AppUserRepository<T> userRepository;

	@Autowired
	public AppUserService(AppUserRepository<T> userRepository) {
		this.userRepository = userRepository;
	}

	public List<T> getAppUsers() {
		return userRepository.findAll();
	}

	public void addAppUser(T AppUser) {
		Optional<T> AppUserOptional = userRepository.findByEmail(AppUser.getEmail());
		if (AppUserOptional.isPresent()) {
			throw new IllegalStateException("email already taken");
		}
		userRepository.save(AppUser);
	}

	public void deleteAppUser(Long id) {
		boolean exists = userRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("AppUser with id " + id + " does not exist");
		}
		userRepository.deleteById(id);
	}

	// TODO: add other properties
	@Transactional
	public void updateAppUser(Long id, String name, String email) {
		// checking that AppUser exists
		T AppUser = userRepository.findById(id)
			.orElseThrow(() -> new IllegalStateException("AppUser with id " + id + " does not exist"));

		// name
		if (name != null && name.length() > 0 && !name.equals(AppUser.getName())) {
			AppUser.setName(name);
		}

		// email
		if ((email != null) && (email.length() > 0) && !email.equals(AppUser.getEmail())) {
			boolean alreadyExists = userRepository.findByEmail(email).isPresent();
			if (alreadyExists) {
				throw new IllegalStateException("email already taken");
			}
			AppUser.setEmail(email);
		}
	}

	public T getAppUser(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new IllegalStateException("AppUser with id " + id + " does not exist"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User name not found"));
	}
}