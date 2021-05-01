package com.example.merchteam.appUser;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.merchteam.gms.GMS;
import com.example.merchteam.planning.Task;

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
			Task task1 =new Task("task1",LocalDate.of(2021, 4, 28),20);
			Task task2 =new Task("task2",LocalDate.of(2021, 4, 28),40);
			GMS v1 =new GMS("gms1","image1",20,12.2,12.2);
			task1.setGms(v1);
			task2.setGms(v1);
			final Merchandiser merchandiser = new Merchandiser(
				passwordEncoder.encode("0000"),
				"merchandiser",
				"merch@spring.co",
				"12123123",
				LocalDate.of(1999, 2, 9)
			);
			merchandiser.getTasks().add(task1);
			merchandiser.getTasks().add(task2);
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