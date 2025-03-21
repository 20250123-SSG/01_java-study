package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.model.User;
import com.sotogito.coffeeshop.serivce.UserService;

import java.util.Optional;

public class UserController {
   private UserService userService;

   public UserController(UserService userService) {
       this.userService = userService;
   }

    public Optional<User> login(String id, String password) {
        return userService.login(id, password);
    }

    public User join(String id, String password, String name, int amount) {
        return userService.join(id, password, name, amount);
    }

    public User findUserById(String id) {
        return userService.findUserById(id);
    }

}
