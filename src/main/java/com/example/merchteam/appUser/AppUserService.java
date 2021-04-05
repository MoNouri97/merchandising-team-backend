package com.example.merchteam.appUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.merchteam.appUser.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService<T extends AppUser> implements UserDetailsService {

	private final AppUserRepository<T> userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AppUserService(AppUserRepository<T> userRepository, PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}

	public List<T> getAppUsers() {
		return userRepository.findAll();
	}

	public T addAppUser(T appUser) {
		Optional<T> AppUserOptional = userRepository.findByEmail(appUser.getEmail());
		if (AppUserOptional.isPresent()) {
			throw new IllegalStateException("email already taken");
		}
		appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
		return userRepository.save(appUser);
	}

	public void deleteAppUser(Long id) {
		boolean exists = userRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("AppUser with id " + id + " does not exist");
		}
		userRepository.deleteById(id);
	}

	@Transactional
	public T updateAppUser(Long id, AppUser updatedUser) {
		String name = updatedUser.getName();
		String email = updatedUser.getEmail();
		String password = updatedUser.getPassword();
		String phone = updatedUser.getPhone();
		LocalDate dob = updatedUser.getDob();
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
			user.setPassword(passwordEncoder.encode(password));
		}

		// phone
		if ((phone != null) && (phone.length() > 0) && !phone.equals(user.getPhone())) {
			user.setPhone(phone);
		}

		// dob
		if ((dob != null) && !dob.isEqual(user.getDob())) {
			user.setDob(dob);
		}

		return user;
	}

	public T getAppUser(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new IllegalStateException("AppUser with id " + id + " does not exist"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByEmail(username)
			.orElseThrow(() -> new UsernameNotFoundException("User name not found"));
	}
}