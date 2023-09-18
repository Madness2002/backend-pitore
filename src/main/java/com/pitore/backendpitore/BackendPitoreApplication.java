package com.pitore.backendpitore;

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

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://tesis-15ed9.web.app","http://localhost:4200","https://tesis-15ed9.web.app").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
