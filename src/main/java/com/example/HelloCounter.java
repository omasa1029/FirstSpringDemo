package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCounter {
	
	@RequestMapping("/")
	public String index() {
		return "This is the Spring Boot sample!";
	}
}
