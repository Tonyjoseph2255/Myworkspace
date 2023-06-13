package com.example.StudentApp.config;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BeanConfig {
	// public ObjectMapper objectMapper(){
	// return new ObjectMapper();
	//
	// }
	@Bean
	public ModelMapper mapper() {

		return new ModelMapper();
	}
}
