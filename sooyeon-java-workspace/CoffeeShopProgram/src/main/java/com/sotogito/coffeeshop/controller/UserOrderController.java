package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.dao.Sales;
import com.sotogito.coffeeshop.dao.ShopProductManager;
import com.sotogito.coffeeshop.dao.UserOrderManager;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;

public class UserOrderController {
    private final UserOrderManager userOrderManager;
    private final ShopProductManager shopProductManager;

    public UserOrderController(UserOrderManager userOrderManager, ShopProductManager shopProductManager) {
        this.userOrderManager = userOrderManager;
        this.shopProductManager = shopProductManager;
    }

    public void order(User user, String productName) {
        validateCanPurchaseStatus(user);

        Product product = shopProductManager.findProductByName(productName);
        userOrderManager.orderByOne(user, product);
        Sales.SALES.add(product);
    }

    public void changeAmount(User user, int amount) {
        userOrderManager.chargeAmount(user, amount);
    }

    public int getUserBalance(User user) {
        return user.getAmount();
    }


    public void validateCanPurchaseStatus(User user) {
        userOrderManager.validateZeroAmount(user);
        userOrderManager.validateOverAmountByMinProduct(user, shopProductManager.getMinimumPrice());
    }

}
