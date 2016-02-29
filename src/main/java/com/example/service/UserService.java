package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.User;

@Service
public interface UserService {
    List<User> getAllUsers();
    
    List<User> getUsersInPage();

    User getUser(Long id);
    
    User addUser(User user);
    
    User modifyUser(User user);
    
    User removeUser(Long id);
}
