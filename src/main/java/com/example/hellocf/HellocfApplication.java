package com.example.hellocf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HellocfApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellocfApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String index() {
		return "Hello (" + System.getenv("CF_INSTANCE_INDEX") + ")";
	}
}
