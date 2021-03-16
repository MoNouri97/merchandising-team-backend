package com.example.merchteam.config;

import java.time.LocalDate;
import java.util.List;

import com.example.merchteam.model.AppUser;
import com.example.merchteam.model.Merchandiser;
import com.example.merchteam.repository.AppUserRepository;
import com.example.merchteam.security.ApplicationUserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppUserConfig {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AppUserConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Bean
	CommandLineRunner commandLineRunner(AppUserRepository<Merchandiser> repository) {
		return (args -> {
			final var user = new Merchandiser(
				passwordEncoder.encode("0000"),
				"user",
				"user@spring.co",
				"12123123",
				LocalDate.of(1997, 2, 9)
			);

			repository.saveAll(List.of(user));

		});

	}

}