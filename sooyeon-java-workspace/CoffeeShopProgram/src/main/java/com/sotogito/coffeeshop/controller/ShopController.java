package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.dao.ShopInformationManager;
import com.sotogito.coffeeshop.dao.ShopProductManager;
import com.sotogito.coffeeshop.dao.UserRepository;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.Shop;
import com.sotogito.coffeeshop.model.User;

import java.util.List;
import java.util.Optional;

public class ShopController {
    private final ShopInformationManager shopInformationManager;
    private final ShopProductManager shopProductManager;
    private final UserRepository userRepository;

    public ShopController(ShopInformationManager shopInformationManager, ShopProductManager shopProductManager, UserRepository shopUserRepository) {
        this.shopInformationManager = shopInformationManager;
        this.shopProductManager = shopProductManager;
        this.userRepository = shopUserRepository;
    }

    public Optional<User> login(String id, String password) {
        return userRepository.findByIdAndPassword(id, password);
    }

    public User join(String id, String password, String name, int amount) {
        User newUser = new User(id, password, name, amount);
        userRepository.addUser(newUser);
        return newUser;
    }

    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    public List<Product> getCoffeeList() {
        return shopProductManager.getCoffeeList();
    }

    public List<Product> getBreadList() {
        return shopProductManager.getBreadList();
    }

    public Shop getShop() {
        return shopInformationManager.getShop();
    }

    public Shop getOriginShop(){
        return shopInformationManager.getOriginalShop();
    }

}
