package com.podoseee.section05.throw_exception;

import com.podoseee.section05.userexception.IncorrectAgeException;
import com.podoseee.section05.userexception.IncorrectGradeException;
import com.podoseee.section05.userexception.IncorrectScoreException;

public class ThrowTest {

    // 자바에서는 예외로 인식하지 못하지만 프로그램에서 요구되는 예외상황이 있음
    // => 직접 throw로 예외를 발생시킬 수 있음
    // => throw new 예외클래스([예외메세지]);

    public void checkScore(int score){
        if(score < 0 || score > 100) {
            //throw new RuntimeException(score + "점은 잘못된 점수입니다.");
            throw new IncorrectScoreException(score + "점은 잘못된 점수입니다.");
        }
        System.out.println(score + "점을 획득하셨습니다.");
    }

    public void checkAge(int age){
        if(age < 0 || age > 120){
            //throw new RuntimeException(age + "살은 존재할 수 없습니다.");
            throw new IncorrectAgeException(age + "살은 존재할 수 없습니다.");
        }

        System.out.println(age + "살 이군요.");
    }

    public void checkGrade(char grade) throws Exception{
        if(!(grade >= 'A' && grade <= 'D')){
            //throw new Exception(grade + "등급은 유효하지 않습니다.");
            throw new IncorrectGradeException(grade + "등급은 유효하지 않습니다.");
        }

        System.out.println(grade + "등급이시군요.");
    }

}
