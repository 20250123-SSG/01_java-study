package com.sotogito.coffeeshop.exception;

public class EmptyPaymentHistory extends RuntimeException {
    public EmptyPaymentHistory(String message) {
        super(message);
    }
}
