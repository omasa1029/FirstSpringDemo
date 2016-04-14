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
public class UserController {

    // TODO 例外処理を共通化
    // TODO Validationを追加

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "This is the Spring Boot sample!";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return userService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get(@RequestParam Long id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public User modify(@RequestBody User user) {
        return userService.modify(user);
    }

    //TODO なぜか、DELETEメソッドでDBに存在しないIDを指定すると、METHOD_NOT_ALLOWEDエラーになる
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public User remove(@RequestParam Long id) {
        userService.remove(id);
        return null;
    }
}
