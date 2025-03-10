package com.minkook.section06.uses.exception;

public class NotEnoughMoneyException extends NegativeException {
    public NotEnoughMoneyException(String message) {
        super(message);
    }

    public NotEnoughMoneyException() {
    }
}
