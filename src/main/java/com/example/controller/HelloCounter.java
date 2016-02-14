package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;

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

////////// Service
interface UserService {
	List<User> getAllUsers();
	User getUser(String userId);
}

@Service
class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId);
	}
}

////////// Repository
interface UserRepository {
	List<User> findAll();
	User findById(String id);
}

@Repository
class UserRepositoryImpl implements UserRepository {
	
	UserData userData = new UserData();
	
	@Override
	public List<User> findAll() {
		return userData.getUserList();
	}

	@Override
	public User findById(String id) {
		List<User> userList = userData.getUserList();
		User user = (User)userList.stream().filter(u -> u.getId().equals(id)).toArray()[0];
		
		return user;
	}
}

////////// Data
class UserData {
	List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public UserData() {
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

		setUserList(Arrays.asList(u1, u2));
	}
}
