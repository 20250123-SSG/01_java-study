package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.model.Shop;
import com.sotogito.coffeeshop.serivce.ShopProductService;
import com.sotogito.coffeeshop.serivce.UserOrderService;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;

import java.util.Map;

public class UserOrderController {
    private final UserOrderService userOrderService;
    private final ShopProductService shopProductService;

    public UserOrderController(UserOrderService userOrderManager, ShopProductService shopProductManager) {
        this.userOrderService = userOrderManager;
        this.shopProductService = shopProductManager;
    }

    public void addCart(User user, String productName) {
        Product product = shopProductService.findProductByName(productName);
        userOrderService.addCartByOne(user, product);
    }

    public void purchaseAllInCart(User user) {
        userOrderService.purchase(user);
    }

    public void changeAmount(User user, int amount) {
        userOrderService.chargeAmount(user, amount);
    }

    public Map<Product, Integer> getCart(User user) {
        return userOrderService.getCart(user);
    }

    public int getUserBalance(User user) {
        return user.getBalance();
    }

    public void clearCart(User user) {
        userOrderService.clearCart(user);
    }

    public void validateCanPurchaseStatus(User user) {
        userOrderService.validateZeroAmount(user);
        userOrderService.validateOverAmountByMinProduct(user, Shop.getMinimumPrice());
    }

}
