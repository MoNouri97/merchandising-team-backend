package com.example.merchteam.gms;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.merchteam.planning.Task;

@Configuration
public class GMSConfig {
	@Bean
CommandLineRunner commandLineRunner3(GMSRepository repository) {
	return args ->{
		GMS v1 =new GMS("gms1","image1",20,12.2,12.2);
		Task task1 =new Task("task1",LocalDate.of(2021, 4, 28),20);
		v1.setTask(task1);
		task1.setGms(v1);
		GMS v2 =new GMS("gms2","image2",30,12.2,12.2);
		GMS v3 =new GMS("gms3","image3",40,12.2,12.2);
		GMS v4 =new GMS("gms4","image4",50,12.2,12.2);
		repository.saveAll(List.of(v1,v2,v3,v4));
	};
}
}
