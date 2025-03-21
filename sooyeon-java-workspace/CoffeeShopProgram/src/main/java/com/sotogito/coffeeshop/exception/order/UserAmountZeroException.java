package com.sotogito.coffeeshop.exception.order;

public class UserAmountZeroException extends RuntimeException {
    public UserAmountZeroException(String message) {
        super(message);
    }
}
