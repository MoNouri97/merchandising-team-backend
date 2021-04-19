package com.example.merchteam.categorie;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CategorieConfig {
	@Bean
CommandLineRunner commandLineRunner2(CategorieRepository repository) {
	return args ->{
		Categorie v1 =new Categorie("Catégorie1");
		Categorie v2 =new Categorie("Catégorie2");
		Categorie v3 =new Categorie("Catégorie3");
		Categorie v4 =new Categorie("Catégorie4");
		repository.saveAll(List.of(v1,v2,v3,v4));
	};
}
}
