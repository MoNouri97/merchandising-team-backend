package com.example.merchteam.competitor;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompetitorConfig {
	@Bean
	CommandLineRunner commandLineRunner4(CompetitorRepository repository) {
		return args -> {
			Competitor v1 = new Competitor("Concurrent1", "category1", "gms1");
			Competitor v2 = new Competitor("Concurrent2", "category2", "gms2");
			Competitor v3 = new Competitor("Concurrent3", "category3", "gms3");
			Competitor v4 = new Competitor("Concurrent4", "category4", "gms4");
			repository.saveAll(List.of(v1, v2, v3, v4));
		};
	}
}
