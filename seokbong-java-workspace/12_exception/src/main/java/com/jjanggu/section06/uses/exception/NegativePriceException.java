package com.jjanggu.section06.uses.exception;

public class NegativePriceException extends NegativeException{

    public NegativePriceException(){}

    public NegativePriceException(String message){
        super(message);
    }
}
