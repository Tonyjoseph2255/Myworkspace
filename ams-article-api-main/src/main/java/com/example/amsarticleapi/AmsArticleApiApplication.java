package com.example.amsarticleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AmsArticleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsArticleApiApplication.class, args);
	}
	
	

}

 