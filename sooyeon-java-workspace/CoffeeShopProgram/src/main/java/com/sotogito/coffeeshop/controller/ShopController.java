package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.dao.ShopProductManager;
import com.sotogito.coffeeshop.dao.UserRepository;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;

import java.util.List;
import java.util.Optional;

public class ShopController {
    private final ShopProductManager shopProductManager;
    private final UserRepository shopUserRepository;

    public ShopController(ShopProductManager shopProductManager, UserRepository shopUserRepository) {
        this.shopProductManager = shopProductManager;
        this.shopUserRepository = shopUserRepository;
    }

    public Optional<User> login(String id, String password) {
        return shopUserRepository.findByIdAndPassword(id, password);
    }

    public void join(User user) {
        shopUserRepository.addUser(user);
    }

    public List<Product> getCoffeeList(){
        return shopProductManager.getCoffeeList();
    }

    public List<Product> getBreadList(){
        return shopProductManager.getBreadList();
    }

}
