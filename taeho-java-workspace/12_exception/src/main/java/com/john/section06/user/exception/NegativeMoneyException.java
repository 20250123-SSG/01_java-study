package com.john.section06.user.exception;

public class NegativeMoneyException extends NegativeException {
    public NegativeMoneyException() {}

    public NegativeMoneyException(String message) {
        super(message);
    }
}
