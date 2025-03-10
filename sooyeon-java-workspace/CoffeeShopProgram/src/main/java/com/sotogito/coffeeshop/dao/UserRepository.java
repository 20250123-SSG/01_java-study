package com.sotogito.coffeeshop.dao;

import com.sotogito.coffeeshop.model.User;

import java.util.*;

public class UserRepository {
    private final Set<User> users = new HashSet<>();

    public void addUser(User user) {
        if (users.contains(user)) {
            throw new IllegalArgumentException("아이디가 중복되었습니다.");
        }
        users.add(user);
    }

    {
        users.add(new User("admin","qwqw1212","관리자",true));

        users.add(new User("sukipi","qwqw1212","수키피",100000));
        users.add(new User("sotogito","qwqw2","기토",0));
        users.add(new User("sukipi","qwqw1212","수키피",100000));
        users.add(new User("sukipi","qwqw1212","수키피",100000));
    }

    public Optional<User> findByIdAndPassword(String id, String password) {
        return users.stream()
                .filter(user -> user.getId().equals(id) && user.getPassword().equals(password))
                .findAny();
    }

}
