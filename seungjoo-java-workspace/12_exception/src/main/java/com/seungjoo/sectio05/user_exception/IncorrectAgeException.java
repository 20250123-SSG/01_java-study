package com.seungjoo.sectio05.user_exception;

public class IncorrectAgeException extends RuntimeException {
    public IncorrectAgeException(String message) {
        super(message);
    }
    public IncorrectAgeException() {}
}
