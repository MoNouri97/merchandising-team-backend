package com.example.merchteam.config;

import java.nio.file.Path;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig {

	@Bean
	public WebMvcConfigurer configCors() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedHeaders("*").allowedOrigins("*");
			}
			@Override
		    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
				Path RESOURCES_DIR = Path.of("src", "main", "resources", "static", "upload").toAbsolutePath();
				System.out.println(RESOURCES_DIR);

		        registry.addResourceHandler("/upload/**").addResourceLocations("file:///"+RESOURCES_DIR+'/');
		    }

		};
	}
}