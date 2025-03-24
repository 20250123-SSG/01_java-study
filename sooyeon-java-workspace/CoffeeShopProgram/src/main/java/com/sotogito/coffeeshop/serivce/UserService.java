package com.sotogito.coffeeshop.serivce;

import com.sotogito.coffeeshop.common.Role;
import com.sotogito.coffeeshop.dao.UserRepository;
import com.sotogito.coffeeshop.exception.user.NoSuchUserException;
import com.sotogito.coffeeshop.model.User;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
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

    public User findUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NoSuchUserException("그런사람업슴다");
        }
        return user.get();
    }

}
