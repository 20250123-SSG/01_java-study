package com.jun.section01.literal;

public class Application1 { // 실제클래스

    public static void main(String[] args){
        /*
            ## java에서 취급하는 값의 종류 ##
            1. 숫자형 (정수, 실수)
            2. 문자형 (문자, 문자열)
            3. 논리형 (참, 거짓)
         */

        // 1. 숫자 : 따옴표 없이 작성
        System.out.println(123);
        System.out.println(1.23);

        // 2. 문자(한글자) : 홑따옴표  같이 작성
        System.out.println('a');
//        System.out.println('abc');

        // 3. 문자열(여러글자) : 쌍따옴표 같이 작성
        System.out.println("안녕");
        System.out.println("A");

        // 4. 논리
        System.out.println(true);
        System.out.println(false);

        // 5. 연산결과 출력
        // 5_1) 숫자간의 연산결과. 숫자는 피연산자 기호는 연산자
        System.out.println(123 + 456);
        System.out.println(1.23 - 0.12); // 컴퓨터에서의 실수값 연산은 불완전해서 오차가 생길 수 있음
        // *(곱셈), /(나누기의 몫),%(나누기의 나머지)

        // 5_2) 문자와 숫자간의 연산결과 - 아스키 코드표 참고
        //      각 문자마다 컴퓨터가 인식하는 고유한 숫자값을 가지고 있음
        //      'a' == 97
        System.out.println('a' + 1); // "98"
        System.out.println('a' - 1);
        System.out.println('a' * 2);

        // 5_3) 문자열과 그외 값 간의 연산 결과
        System.out.println("a" + 1); // "a1"
        System.out.println(1 + "a"); // "1a"
        System.out.println("안녕" + true); // "안녕true"
        System.out.println("안녕" + 1 + 2 + '!'); // "안녕12!"
        System.out.println("안녕" + (1 + 2) + '!'); // "안녕3!"


    }
}
