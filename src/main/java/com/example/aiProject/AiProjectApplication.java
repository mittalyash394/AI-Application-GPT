package com.example.aiProject;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiProjectApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv
				.configure()
				.ignoreIfMissing() // important for CI / prod
				.load();

		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);

		SpringApplication.run(AiProjectApplication.class, args);
	}

}
