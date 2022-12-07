package com.brian.TmocRanker;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EntityScan("com.brian.TmocRanker.entities")
@EnableJpaRepositories("com.brian.TmocRanker.repos")
public class TmocRankerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmocRankerApplication.class, args);
	}
	

}
