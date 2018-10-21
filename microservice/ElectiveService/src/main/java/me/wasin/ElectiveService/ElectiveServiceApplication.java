package me.wasin.ElectiveService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ElectiveServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectiveServiceApplication.class, args);
	}
}
