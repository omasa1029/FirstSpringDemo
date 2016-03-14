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

    // TODO トランザクション、なぜかアノテーションつけなくてもトランザクションが効いてるぽい？
    // TODO トランザクションのベースクラスにアノテーションをつけておく

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();

        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(element -> users.add(element));

        return users;
    }

    @Override
    public List<User> getInPage() {
        List<User> users = new ArrayList<User>();

        Iterable<User> iterable = userRepository.findAll(UserRepository.DEFAULT_PAGE_REQUEST);
        iterable.forEach(element -> users.add(element));

        return users;
    }

    @Override
    public User get(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User add(User user) {
        userRepository.save(user);
        // TODO 後で削除 例外を発生させる
        userRepository.delete(0L);
        // return userRepository.save(user);
        return null;
    }

    @Override
    public User modify(User user) {
        userRepository.save(user);
        // TODO 後で削除 例外を発生させる
        userRepository.delete(0L);
        // return userRepository.save(user);
        return null;
    }

    @Override
    public User remove(Long id) {
        userRepository.delete(id);
        // TODO 後で削除 例外を発生させる
        userRepository.delete(0L);
        return null;
    }
}
