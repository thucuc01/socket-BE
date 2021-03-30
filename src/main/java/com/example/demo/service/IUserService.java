package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IGenneralService<User> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    List<User> getFriends(String username);
}
