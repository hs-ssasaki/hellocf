package com.example.hellocf;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCaching
public class HellocfApplication {
	@Autowired
	Greeter greeter;

	public static void main(String[] args) {
		SpringApplication.run(HellocfApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String index() {
		return greeter.hello();
	}
}

@Component
class Greeter {
	@Cacheable("hello") // 実行結果をキャッシュします
	public String hello() {
		return "Hello. It's " + OffsetDateTime.now() + " now.";
	}
}