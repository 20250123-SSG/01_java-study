package com.john.section05.userexception;

/*
    사용자 정의 예외 클래스
    - Exception 또는 RuntimeException을 상속받아 구현
        - 예외 처리를 강제화 시키고자 할 경우 => Exception
        - 예외 처리를 강제화 시키지 않게 할 경우 => Runtime Exception
    - 기본생성자 -> 예외메시지가 null로 기록
    - 메시지를 전달받을 수 있는 매개변수 생성자 - 전달된 메시지를 부모로 다시 전달
 */
public class IncorrectGradeException extends Exception {
    public IncorrectGradeException() {

    }

    public IncorrectGradeException(String message) {
        super(message);
    }
}
