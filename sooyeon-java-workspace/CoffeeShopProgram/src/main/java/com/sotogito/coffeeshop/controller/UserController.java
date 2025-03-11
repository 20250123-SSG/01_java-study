package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.common.Role;
import com.sotogito.coffeeshop.dao.UserRepository;
import com.sotogito.coffeeshop.model.User;

import java.util.Optional;

public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> login(String id, String password) {
        return userRepository.findByIdAndPassword(id, password);
    }

    public User join(String id, String password, String name, int amount) {
        User newUser = new User(id, password, name, amount, Role.USER);
        userRepository.addUser(newUser);
        return newUser;
    }


    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

}
