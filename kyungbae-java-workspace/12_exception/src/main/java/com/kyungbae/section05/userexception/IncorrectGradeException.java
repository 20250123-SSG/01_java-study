package com.kyungbae.section05.userexception;

public class IncorrectGradeException extends Exception {

    public IncorrectGradeException(){}

    public IncorrectGradeException(String messege){
        super(messege);
    }

}
