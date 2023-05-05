package com.example.springBoot21;

import com.example.springBoot21.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // Configuration, EnableAutoConfiguration, ComponentScan
public class SpringBoot21Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot21Application.class, args);
	}

	@Bean // with Configuration annotation
	public CommandLineRunner init(UserRepo userRepo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println(userRepo.findAll());
			}
		};
	}

}
