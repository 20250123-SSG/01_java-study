package com.seungjoo.sectio05.throw_exception;

import com.seungjoo.sectio05.user_exception.IncorrectAgeException;
import com.seungjoo.sectio05.user_exception.IncorrectGradeException;
import com.seungjoo.sectio05.user_exception.IncorrectScoreException;


public class Throw_test {
    public void checkScore(int score){



    if(score < 0 || score > 100){
        throw new IncorrectScoreException();
    }
        System.out.println(score + "점을 획득하셨습니다.");




    }
    public void checkAge(int age){
       if(age < 0 || age > 100){
           throw new IncorrectAgeException(age + "살은 존재할 수 없습니다.");
       }
     System.out.println(age + "살 이군요.");


    }
    public void checkGrade(char grade) throws Exception{
        if(grade < 0 || grade > 100){
            throw new IncorrectGradeException();
        }
        System.out.println(grade + "등급이시군요.");
    }


}
