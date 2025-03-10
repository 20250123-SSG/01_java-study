package com.pch.section06.uses.exception;

public class NegativeMoneyException extends Exception{
    public NegativeMoneyException(){}

    public NegativeMoneyException(String message){
        super(message);
    }
}
