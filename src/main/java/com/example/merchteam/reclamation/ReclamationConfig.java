package com.example.merchteam.reclamation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ReclamationConfig {
	@Bean
	CommandLineRunner commandLineRunner12(ReclamationRepository repository) {
		return args -> {
			// Reclamation v1 = new Reclamation;
			// Reclamation v2 = new Reclamation("Reclamation2","gms2","merchandiser2");
			// Reclamation v3 = new Reclamation("Reclamation3","gms3","merchandiser3");
			// Reclamation v4 = new Reclamation("Reclamation4","gms4","merchandiser4");
			// repository.saveAll(List.of(v1, v2, v3, v4));
		};
	}
}
