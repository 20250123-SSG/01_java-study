package com.pch.section06.uses.exception;

public class NegativePriceException extends Exception{
    public NegativePriceException(){}

    public NegativePriceException(String message){
        super(message);
    }
}
