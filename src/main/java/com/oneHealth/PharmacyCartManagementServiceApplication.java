package com.oneHealth;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PharmacyCartManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyCartManagementServiceApplication.class, args);
	}
	@GetMapping
	public String Welcome() {

        // This method handles GET requests to the root URL and returns a welcome message.

        return "Welcome From OneHealth Team (Pharmacy Cart Management Service)!!!";

    }

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
