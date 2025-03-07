package com.sotogito.coffeeshop.exception;

public class UserAmountZeroException extends RuntimeException {
    public UserAmountZeroException(String message) {
        super(message);
    }
}
