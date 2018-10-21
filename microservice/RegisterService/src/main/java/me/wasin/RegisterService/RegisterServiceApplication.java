package me.wasin.RegisterService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RegisterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterServiceApplication.class, args);
	}
}
