package com.sotogito.coffeeshop.dao;

import com.sotogito.coffeeshop.common.Role;
import com.sotogito.coffeeshop.exception.user.DuplicateIdException;
import com.sotogito.coffeeshop.model.User;

import java.util.*;

public class UserRepository {
    private final Set<User> users = new HashSet<>();

    {
        users.add(new User("admin", "qwqw1212", "관리자", 0, Role.ADMIN));

        users.add(new User("sukipi", "qwqw1212", "수키피", 100000, Role.USER));
        users.add(new User("sotogito", "qwqw2", "기토", 0, Role.USER));
        users.add(new User("rjwl", "rjwl", "거지", 30, Role.USER));
        users.add(new User("qwe", "qwe", "qwe", 0, Role.USER));
    }


    public void addUser(User user) {
        if (users.contains(user)) {
            throw new DuplicateIdException("아이디가 중복되었습니다.");
        }
        users.add(user);
    }

    public Optional<User> findByIdAndPassword(String id, String password) {
        return users.stream()
                .filter(user -> user.getId().equals(id) && user.getPassword().equals(password))
                .findAny();
    }

    public Optional<User> findById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findAny();
    }

}
