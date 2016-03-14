package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class HelloCounter {

    // TODO 例外処理を共通化

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "This is the Spring Boot sample!";
    }

    @RequestMapping("/list")
    public List<User> getUserList() {
        return userService.getAll();
    }

    @RequestMapping("/get")
    public User getUser(@RequestParam Long id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public User modifyUser(@RequestBody User user) {
        return userService.modify(user);
    }

    @RequestMapping("/remove")
    public User removeUser(@RequestParam Long id) {
        return userService.remove(id);
    }
}
