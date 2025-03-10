package com.minkook.section05.user_exception;

public class IncorrectAgeException extends RuntimeException {
    public IncorrectAgeException() {
    }

    public IncorrectAgeException(String message) {
        super(message);
    }
}
