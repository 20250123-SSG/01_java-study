package com.ino.section06.uses.exception;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {}
    public NotEnoughMoneyException(String message){
        super(message);
    }
}
