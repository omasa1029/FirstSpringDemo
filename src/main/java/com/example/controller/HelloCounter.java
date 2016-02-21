package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class HelloCounter {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String index() {
		return "This is the Spring Boot sample!";
	}

	@RequestMapping("/userlist")
	public List<User> getUserList() {
		return userService.getAllUsers();
	}

	@RequestMapping("/user")
	public User getUser(@RequestParam String userId) {
		return userService.getUser(userId);
	}
}
