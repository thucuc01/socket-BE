package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/user/{username}")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/friend")
    public List<User> getFriends(@PathVariable("username")String username) {
        return userService.getFriends(username);
    }

    @GetMapping
    public User getUser(@PathVariable("username") String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            return userService.findByUsername(username).get();
        }
        return null;
    }
}