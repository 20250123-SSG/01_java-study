package com.ino.section05.throw_exception;

import com.ino.section05.userexception.IncorrectAgeException;
import com.ino.section05.userexception.IncorrectGradeException;
import com.ino.section05.userexception.IncorrectScoreException;

public class ThrowTest {
    public void checkGrade(char grade) throws Exception {
        if (!(grade >= 'A' && grade <= 'D')) {
            throw new IncorrectGradeException(grade + "등급은 유효하지 않습니다.");
        }
    }

    public void checkAge(int age) {
        if (age < 0 || age > 120) {
            throw new IncorrectAgeException(age + "살은 존재할 수 없습니다.");
        }
    }

    public void checkScore(int score) {
        if(score < 0 || score > 100) {
            throw new IncorrectScoreException(score + "점은 없습니다.");
        }

        System.out.println(score + "점을 획득하셨습니다.");
    }
}
