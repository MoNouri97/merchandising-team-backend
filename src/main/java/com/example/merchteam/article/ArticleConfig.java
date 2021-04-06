package com.example.Merchandising.article;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleConfig {
	@Bean
CommandLineRunner commandLineRunner(ArticleRepository repository) {
	return args ->{
		Article gh =new Article("BUCATINI","12LC11","Long pasta","6194043401178","12","12.2","categorie1");
		Article med =new Article("BUCATINI","12LC11","Long pasta","6194043401178","13","13.2","categorie2");
		repository.saveAll(List.of(gh,med));
	};
}
}
