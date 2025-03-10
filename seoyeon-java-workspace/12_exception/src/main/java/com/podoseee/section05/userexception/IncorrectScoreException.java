package com.podoseee.section05.userexception;

public class IncorrectScoreException extends RuntimeException {
    public IncorrectScoreException(String message) {
        super(message);
    }
}
