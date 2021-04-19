package com.example.merchteam.concurrent;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConcurrentConfig {
	@Bean
CommandLineRunner commandLineRunner4(ConcurrentRepository repository) {
	return args ->{
		Concurrent v1 =new Concurrent("Concurrent1","category1","gms1");
		Concurrent v2 =new Concurrent("Concurrent2","category2","gms2");
		Concurrent v3 =new Concurrent("Concurrent3","category3","gms3");
		Concurrent v4 =new Concurrent("Concurrent4","category4","gms4");
		repository.saveAll(List.of(v1,v2,v3,v4));
	};
}
}
