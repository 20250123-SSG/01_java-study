package com.sotogito.coffeeshop.exception;

public class UserAmountShortThanMinPriceException extends RuntimeException {
    public UserAmountShortThanMinPriceException(String message) {
        super(message);
    }
}
