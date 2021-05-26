package com.example.merchteam.appUser;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
//			LocalDateTime dateTimeTask2 = LocalDateTime.of(2021, 5, 18, 11, 30, 0).plusMinutes(40);
//			LocalDateTime dateTimeTask1 = LocalDateTime.of(2021, 5, 19, 11, 30, 0).plusMinutes(20);
//			Task task1 =new Task("task1",LocalDateTime.of(2021, 5, 19, 11, 30, 0),dateTimeTask1,20);
//			Task task2 =new Task("task2",LocalDateTime.of(2021, 5, 18, 11, 30, 0),dateTimeTask2,40);
//			GMS v1 =new GMS("gms1","image1",20,12.2,12.2);
//			GMS v2 =new GMS("gms2","image1",20,12.2,12.2);
//			task1.setGms(v1);
//			task2.setGms(v2);
			final Merchandiser merchandiser = new Merchandiser(
				passwordEncoder.encode("0000"),
				"merchandiser",
				"merch@spring.co",
				"12123123",
				LocalDate.of(1999, 2, 9)
			);
//			merchandiser.getTasks().add(task1);
//			merchandiser.getTasks().add(task2);
//			
//			LocalDateTime dateTimeTask3 = LocalDateTime.of(2021, 5, 17, 11, 30, 0).plusMinutes(20);
//			LocalDateTime dateTimeTask4 = LocalDateTime.of(2021, 5, 20, 11, 30, 0).plusMinutes(40);
//			Task task3 =new Task("task3",LocalDateTime.of(2021, 5, 17, 11, 30, 0),dateTimeTask3,20);
//			Task task4 =new Task("task4",LocalDateTime.of(2021, 5, 20, 11, 30, 0),dateTimeTask4,40);
//			GMS v3 =new GMS("gms3","image1",20,12.2,12.2);
//			GMS v4 =new GMS("gms4","image1",20,12.2,12.2);
//			task3.setGms(v3);
//			task4.setGms(v4);
			final Merchandiser merchandiser2 = new Merchandiser(
				passwordEncoder.encode("0000"),
				"merchandiser 2",
				"merch2@spring.co",
				"12123123",
				LocalDate.of(1999, 2, 9)
			);
//			merchandiser2.getTasks().add(task3);
//			merchandiser2.getTasks().add(task4);
//			
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
			merchRepo.save(merchandiser2);
			sVisorRepo.save(supervisor);
			adminRepo.save(admin);

		});

	}

}