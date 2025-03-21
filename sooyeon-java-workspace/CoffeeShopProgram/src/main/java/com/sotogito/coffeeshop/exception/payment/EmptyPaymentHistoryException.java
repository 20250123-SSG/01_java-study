package com.sotogito.coffeeshop.exception.payment;

public class EmptyPaymentHistoryException extends RuntimeException {
    public EmptyPaymentHistoryException(String message) {
        super(message);
    }
}
