package com.pch.section04.references;

import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        /*
            ## 메소드 참조 ##
            1.  함수형 인터페이스를 람다식이 아닌 일반 메소드를 참조시켜 선언하는 방법
            2.  이미 존재하는 메소드를 참조하여 람다식에서 불필요한 매개변수 선언을 제거할 수 있음
            3.  함수형 인터페이스의 매개변수, 반환타입과 참조할 메소드의 매개변수, 반환타입이 같아야됨
            4.  표현식
                1) 정적 메소드 참조 => 클래스명::staticMethodName
                2) 인스턴스 메소드 참조 => 참조변수::instanceMethodName
                3) 특정 타입의 객체 메소드 참조 => 타입::methodName
                4) 생성자 참조 => 클래스명::new
         */

        // case1. 특정 정수값을 전달받아 절대값을 반환해주는 Function
        Function<Integer, Integer> function = Math::abs; // 전달값 가지고 static 메소드 실행 결과 반환
    }
}
