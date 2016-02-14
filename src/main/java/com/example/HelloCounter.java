package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCounter {

	@RequestMapping("/")
	public String index() {
		return "This is the Spring Boot sample!";
	}

	@RequestMapping("/json")
	public List<User> json() {

		User u1 = new User() {
			{
				setId("1");
				setName("Tanaka");
			}
		};
		User u2 = new User() {
			{
				setId("2");
				setName("Satou");
			}
		};

		List<User> l = Arrays.asList(u1, u2);
		return l;
	}
}

class User {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
}