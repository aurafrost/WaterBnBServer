package com.waterbnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan("com.waterbnb.*")
public class WaterBnBServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaterBnBServerApplication.class, args);
	}

}