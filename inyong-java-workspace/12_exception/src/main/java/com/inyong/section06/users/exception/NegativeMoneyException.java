package com.inyong.section06.users.exception;

public class NegativeMoneyException extends Exception {

    public NegativeMoneyException() {
    }

    public NegativeMoneyException(String message) {
        super(message);
    }

}
