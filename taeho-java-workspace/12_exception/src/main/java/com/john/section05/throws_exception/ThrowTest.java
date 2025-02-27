
package com.john.section05.throws_exception;

import com.john.section05.userexception.IncorrectAgeException;
import com.john.section05.userexception.IncorrectGradeException;

public class ThrowTest {
    public void checkScore(int score){
        if(score < 0 || score > 100){
            throw new RuntimeException(score + " 점은 잘못된 점수입니다.");
        }
        System.out.println(score + " 점을 획득했습니다");
    }

    public void checkAge(int age){
        if(age < 0 || age > 120){
//            throw new RuntimeException(age + " 살은 좀..");
            throw new IncorrectAgeException(age + " 살은 좀..");
        }
        System.out.println(age + " 살 이군요.");
    }

    public void checkGrade(char grade) throws IncorrectGradeException {
        if(!(grade >= 'A' && grade <= 'D')){
//            throw new RuntimeException(grade + " 등급은 없는 등급입니다.");
            throw new IncorrectGradeException(grade + " 등급은 없는 등급입니다.");
        }
        System.out.println(grade + " 등급이군요");
    }
}
