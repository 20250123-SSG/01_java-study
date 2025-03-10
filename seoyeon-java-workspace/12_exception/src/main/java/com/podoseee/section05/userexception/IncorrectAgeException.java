package com.podoseee.section05.userexception;

public class IncorrectAgeException extends RuntimeException {
    public IncorrectAgeException(String message){
        super(message);
    }
}
