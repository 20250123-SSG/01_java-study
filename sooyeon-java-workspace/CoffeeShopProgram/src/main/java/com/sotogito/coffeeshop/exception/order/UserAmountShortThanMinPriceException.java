package com.sotogito.coffeeshop.exception.order;

public class UserAmountShortThanMinPriceException extends RuntimeException {
    public UserAmountShortThanMinPriceException(String message) {
        super(message);
    }
}
