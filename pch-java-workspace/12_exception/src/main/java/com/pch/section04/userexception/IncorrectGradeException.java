package com.pch.section04.userexception;

public class IncorrectGradeException extends Exception {

    /*
        ## 사용자 정의 예외클래스 만들기 ##
        1.  Exception 또는 RuntimeException을 상속받아 구현
            - 예외처리를 강제화 시키고자 할 경우 => Exception => checked Excption 이 됨
            - 예외처리를 강제화 시키지 않게 할 경우 => RuntimeException => unchecked Exception이 됨
        2. 기본생성자 -> 예외메세지가 null로 기록됨
        3. 메세지를 전달받을 수 있는 매개변수 생성자 - 전달된 메세지를 부모로 다시 전달
     */

    public IncorrectGradeException() {
    }

    public IncorrectGradeException(String message) {

    }
}
