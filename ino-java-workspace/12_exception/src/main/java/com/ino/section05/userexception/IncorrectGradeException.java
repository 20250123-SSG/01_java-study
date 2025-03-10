package com.ino.section05.userexception;

public class IncorrectGradeException extends Exception{

    public IncorrectGradeException(){}

    public IncorrectGradeException(String message) {
        super(message);
    }
}
