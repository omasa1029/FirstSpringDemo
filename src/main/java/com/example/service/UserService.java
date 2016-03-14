package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;

@Service
@Transactional(readOnly = true)
public interface UserService {
    List<User> getAll();

    List<User> getInPage();

    User get(Long id);

    User add(User user);

    User modify(User user);

    User remove(Long id);
}
