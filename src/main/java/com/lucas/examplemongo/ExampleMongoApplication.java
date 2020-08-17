package com.lucas.examplemongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ExampleMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleMongoApplication.class, args);
	}

}
