package com.example.merchteam.category;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {
	@Bean
	CommandLineRunner commandLineRunner2(CategoryRepository repository) {
		return args -> {
			Category v1 = new Category("Catégorie1");
			Category v2 = new Category("Catégorie2");
			Category v3 = new Category("Catégorie3");
			Category v4 = new Category("Catégorie4");
			repository.saveAll(List.of(v1, v2, v3, v4));
		};
	}
}
