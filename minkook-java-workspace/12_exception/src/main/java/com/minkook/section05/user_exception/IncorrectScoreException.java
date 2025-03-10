package com.minkook.section05.user_exception;

public class IncorrectScoreException extends RuntimeException {
    public IncorrectScoreException() {
    }

    public IncorrectScoreException(String message) {
        super(message);
    }
}
