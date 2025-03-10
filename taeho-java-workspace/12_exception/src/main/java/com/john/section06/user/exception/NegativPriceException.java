package com.john.section06.user.exception;

public class NegativPriceException extends NegativeException {
    public NegativPriceException(){}

    public NegativPriceException(String message) {
        super(message);
    }
}
