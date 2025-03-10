package com.minkook.section06.uses.exception;

public class NegativeMoneyException extends NegativeException {
    public NegativeMoneyException(){

    }
    public NegativeMoneyException(String message){
        super(message);
    }
}
