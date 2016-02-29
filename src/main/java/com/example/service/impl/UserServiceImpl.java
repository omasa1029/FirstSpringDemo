package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    //TODO トランザクションとロギング

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        
        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(element -> users.add(element));
        
        return users;
    }

    @Override
    public List<User> getUsersInPage() {
        List<User> users = new ArrayList<User>();
        
        Iterable<User> iterable = userRepository.findAll(UserRepository.DEFAULT_PAGE_REQUEST);
        iterable.forEach(element -> users.add(element));
        
        return users;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User modifyUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User removeUser(Long id) {
        userRepository.delete(id);
        return null;
    }
}
