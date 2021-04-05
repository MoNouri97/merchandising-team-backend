package com.example.merchteam.appUser;

import java.time.LocalDate;

import com.example.merchteam.appUser.repository.AppUserRepository;

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
	CommandLineRunner commandLineRunner(
		AppUserRepository<Merchandiser> merchRepo,
		AppUserRepository<Admin> adminRepo,
		AppUserRepository<Supervisor> sVisorRepo
	) {
		return (args -> {
			final Merchandiser merchandiser = new Merchandiser(
				passwordEncoder.encode("0000"),
				"merchandiser",
				"merch@spring.co",
				"12123123",
				LocalDate.of(1999, 2, 9)
			);
			final Supervisor supervisor = new Supervisor(
				passwordEncoder.encode("0000"),
				"supervisor",
				"supervisor@spring.co",
				"12123123",
				LocalDate.of(1998, 2, 9)
			);
			final Admin admin = new Admin(
				passwordEncoder.encode("0000"),
				"admin",
				"admin@spring.co",
				"12123123",
				LocalDate.of(1997, 2, 9)
			);

			merchRepo.save(merchandiser);
			sVisorRepo.save(supervisor);
			adminRepo.save(admin);

		});

	}

}