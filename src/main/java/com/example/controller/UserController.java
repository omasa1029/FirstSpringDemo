package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.exception.ApplicationException;
import com.example.http.Responce;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    // TODO 返却するJSONを共通化

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "This is the Spring Boot sample!";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Responce list() {
        return new Responce(userService.getAll());
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Responce get(@RequestParam Long id) {
        return new Responce(userService.get(id));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Responce add(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            throw new ApplicationException("E-0001", errors);
        }
        return new Responce(userService.add(user));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public Responce modify(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            throw new ApplicationException("E-0002", errors);
        }
        return new Responce(userService.modify(user));
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public Responce remove(@RequestParam Long id) {
        userService.remove(id);
        return new Responce(null);
    }
}
