package com.sotogito.coffeeshop.dao;

import com.sotogito.coffeeshop.exception.UserAmountShortThanMinPriceException;
import com.sotogito.coffeeshop.exception.UserAmountZeroException;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;


public class UserOrderManager {

    public void chargeAmount(User user, int amount) {
        user.chargeAmount(amount);
    }

    public void orderByOne(User user, Product product) {
        user.purchase(product);
        user.addOrder(product);
    }

    public void validateOverAmountByMinProduct(User user, int minPrice) {
        if (!user.isOverAmountThanProductPrice(minPrice)) {
            throw new UserAmountShortThanMinPriceException("상품의 최소 금액보다 잔액이 부족합니다.");
        }
    }

    public void validateZeroAmount(User user) {
        if (user.isZeroAmount()) {
            throw new UserAmountZeroException("잔액이 없습니다.");
        }
    }

}
