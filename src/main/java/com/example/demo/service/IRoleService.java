package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.Optional;

public interface IRoleService extends IGenneralService<Role> {
    Optional<Role> findByName(String name);

}
