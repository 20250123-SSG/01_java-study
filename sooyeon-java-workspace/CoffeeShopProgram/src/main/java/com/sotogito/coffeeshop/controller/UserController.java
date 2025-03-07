package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.dao.ShopProductManager;
import com.sotogito.coffeeshop.dao.UserOrderManager;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;

public class UserController {
    private final UserOrderManager userOrderManager;
    private final ShopProductManager shopProductManager;

    public UserController(UserOrderManager userOrderManager, ShopProductManager shopProductManager) {
        this.userOrderManager = userOrderManager;
        this.shopProductManager = shopProductManager;
    }

    public void changeAmount(User user, int amount) {
        userOrderManager.chargeAmount(user, amount);
    }

    public void order(User user, String productName) {
        userOrderManager.validateZeroAmount(user);
        userOrderManager.validateOverAmountByMinProduct(user, shopProductManager.getMinimumPrice());

        Product product = shopProductManager.findProductByName(productName);
        userOrderManager.orderByOne(user, product);
    }

}
