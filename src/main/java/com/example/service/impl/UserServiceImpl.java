package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    // TODO Transactional ReadOnly=True はどんな意味？
    /*
     READ ONLY 句を指定すると、そのトランザクションは読み取り専用モードになります。
     このトランザクションで SELECT 文を実行すると、トランザクション開始前の状態のデータを参照することができます。
     このトランザクション実行中に他のトランザクションでデータに変更が加えられても、その前の状態のデータを参照できるということです。
     */

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
        return userRepository.save(user);
    }

    @Override
    public User modify(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.delete(id);
    }
}
