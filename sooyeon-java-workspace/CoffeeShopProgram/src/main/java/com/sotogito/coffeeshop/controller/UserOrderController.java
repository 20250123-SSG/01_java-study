package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.model.Shop;
import com.sotogito.coffeeshop.serivce.ShopProductService;
import com.sotogito.coffeeshop.serivce.UserOrderService;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;

public class UserOrderController {
    private final UserOrderService userOrderManager;
    private final ShopProductService shopProductManager;

    public UserOrderController(UserOrderService userOrderManager, ShopProductService shopProductManager) {
        this.userOrderManager = userOrderManager;
        this.shopProductManager = shopProductManager;
    }

    public void addCart(User user, String productName) {
        Product product = shopProductManager.findProductByName(productName);
        userOrderManager.addCartByOne(user, product);
    }

    public void purchaseAllInCart(User user) {
        userOrderManager.purchase(user);
    }

    public void changeAmount(User user, int amount) {
        userOrderManager.chargeAmount(user, amount);
    }

    public int getUserBalance(User user) {
        return user.getBalance();
    }

    public void clearCart(User user) {
        userOrderManager.clearCart(user);
    }

    public void validateCanPurchaseStatus(User user) {
        userOrderManager.validateZeroAmount(user);
        userOrderManager.validateOverAmountByMinProduct(user, Shop.getMinimumPrice());
    }

}
