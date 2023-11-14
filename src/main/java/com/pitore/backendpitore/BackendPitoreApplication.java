package com.pitore.backendpitore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendPitoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPitoreApplication.class, args);
	}


	@Value("${FRONT1}")
	private String front1;

	@Value("${FRONT2}")
	private String front2;
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(front1,"http://localhost:4200","front2").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
