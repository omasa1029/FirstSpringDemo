package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.User;

@Service
public interface UserService {
	List<User> getAllUsers();

	User getUser(String userId);
}
