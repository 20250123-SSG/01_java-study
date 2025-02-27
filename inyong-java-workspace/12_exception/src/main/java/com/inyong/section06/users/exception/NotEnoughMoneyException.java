package com.inyong.section06.users.exception;

public class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException() {

    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
