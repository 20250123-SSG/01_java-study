package com.kyungbae.section05.throw_exception;

import com.kyungbae.section05.userexception.IncorrectAgeException;
import com.kyungbae.section05.userexception.IncorrectGradeException;
import com.kyungbae.section05.userexception.IncorrectScoreException;

public class ThrowTest {

    // 자바에서는 예외로 인식하지 못하지만 프로그램에서 요구되는 예외상황이 있음

    // 점수를 0~100 사이로 받아야 한다
    public void checkScore(int score){
        if(score < 0 || score > 100){
//            throw new RuntimeException(score + "점은 잘못된 점수입니다.");
            throw  new IncorrectScoreException(score + "점은 잘못됐다");
            // Unchecked Exception
        }


        System.out.println(score + "점");
    }

    public void checkAge(int age){
        if (age < 0 || age > 120) {
            throw new IncorrectAgeException(age + "살은 없어요");
        }
        System.out.println(age + "살");
    }

    public void checkGrade(char grade) throws IncorrectGradeException {
        if (!(grade >= 'A' && grade <= 'D') ){
            throw new IncorrectGradeException("안됨"); // checked exception
        }
        System.out.println(grade + "등급");
    }

}
