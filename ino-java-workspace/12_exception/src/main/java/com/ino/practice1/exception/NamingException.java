package com.ino.practice1.exception;

public class NamingException extends RuntimeException{
    public NamingException(){}
    public NamingException(String message){
        super(message);
    }
}
