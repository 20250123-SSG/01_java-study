package com.sotogito.coffeeshop.exception.order;

public class UserAmountShortException extends RuntimeException {
    public UserAmountShortException(String message) {
        super(message);
    }
}
