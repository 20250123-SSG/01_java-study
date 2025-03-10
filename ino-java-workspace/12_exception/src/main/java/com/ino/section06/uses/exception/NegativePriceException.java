package com.ino.section06.uses.exception;

public class NegativePriceException extends Exception {
    public NegativePriceException(String message) {
        super(message);
    }
}
