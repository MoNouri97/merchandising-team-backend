package com.example.merchteam.service;

import java.time.LocalDate;
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

	@Transactional
	public void updateAppUser(Long id, String name, String email, String password, String phone, LocalDate dob) {
		// checking that AppUser exists
		T user = userRepository.findById(id)
			.orElseThrow(() -> new IllegalStateException("AppUser with id " + id + " does not exist"));

		// name
		if (name != null && name.length() > 0 && !name.equals(user.getName())) {
			user.setName(name);
		}

		// email
		if ((email != null) && (email.length() > 0) && !email.equals(user.getEmail())) {
			boolean alreadyExists = userRepository.findByEmail(email).isPresent();
			if (alreadyExists) {
				throw new IllegalStateException("email already taken");
			}
			user.setEmail(email);
		}

		// password
		if ((password != null) && (password.length() > 0) && !password.equals(user.getPassword())) {
			user.setPassword(password);
		}

		// phone
		if ((phone != null) && (phone.length() > 0) && !phone.equals(user.getPhone())) {
			user.setPhone(phone);
		}

		// dob
		if ((dob != null) && !dob.isEqual(user.getDob())) {
			user.setDob(dob);
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