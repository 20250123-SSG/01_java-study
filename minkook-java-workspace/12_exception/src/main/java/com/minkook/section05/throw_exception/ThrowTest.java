package com.minkook.section05.throw_exception;

public class ThrowTest {
    //자바에서는 예외로 인식하지 못하지만 프로그램에서 요구되는 예외사항이 있음
    // => 직접 throw로 예외를 발생시킬 수 있음
    // => throw new 예외클래스([예외메시지]);

    public void checkScore(int score){
        if(score < 0 || score > 100){
            throw new RuntimeException(score + "살은 존재할 수 없습니다.");
        }
        System.out.println(score+"점을 획득하셨습니다.");
    }
    
    public void checkAge(int age){
        if(age < 0 || age > 120){
            throw new RuntimeException(age + "살은 존재할 수 없습니다.");
        }
        System.out.println(age + "살 이군요");
    }
    
    public void checkGrade(char grade) throws Exception {
        if(!(grade >= 'A' && grade <= 'D')){
            throw new Exception(grade + "등급은 유효하지 않습니다."); //checked exception => 예외 핸들링 필수
        }
        System.out.println(grade + "등급이시군요.");
    }

}
