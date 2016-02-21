package com.example.repository;

import java.util.List;

import com.example.entity.User;

public interface UserRepository {
    List<User> findAll();

    User findById(String id);
}
