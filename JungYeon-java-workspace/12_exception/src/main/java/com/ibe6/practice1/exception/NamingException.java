package com.ibe6.practice1.exception;

public class NamingException extends Exception {
    public NamingException(){
        super("변수 명명 규칙에 어긋납니다.");
    }

    public NamingException(String message){
        super(message);
    }

}
