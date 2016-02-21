package com.example.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.repository.UserRepository;

//TODO JPA化
@Repository
public class UserRepositoryImpl implements UserRepository {

    UserData userData = new UserData();

    @Override
    public List<User> findAll() {
        return userData.getUserList();
    }

    @Override
    public User findById(String id) {
        List<User> userList = userData.getUserList();
        User user = (User) userList.stream().filter(u -> u.getId().equals(id)).toArray()[0];

        return user;
    }
}

// TODO インメモリDB化
class UserData {
    List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserData() {
        User u1 = User.builder().id("1").name("Tanaka").build();
        User u2 = User.builder().id("2").name("Satou").build();

        setUserList(Arrays.asList(u1, u2));
    }
}
