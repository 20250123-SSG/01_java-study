package com.jjanggu.section03.unchecked_checked;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        /*
            ## Unchecked Exception ##
            1. 예외처리구문이 없어도 프로그램 동작돠는 예외클래스들
               즉, 컴파일 에러가 없기 때문에 프로그램 실행에는 문제없음
               단, 사용자가 프로그램을 잘못 사용했다거나 개발자가 특정 케이스를 제대로 처리하지 않아 발생되는 예외
            2. 예외처리를 강제화 시키지 않았기 때문에 예외핸들링(예외처리/예외회피)하는게 필수는 아님 (선택사항)
            3. 간단한 조건문으로 애초에 예외가 발생되지 않도록 처리도 가능 (권장사항)
            4. RuntimeException 클래스와 그 하위 클래스들
               - ArithmeticException
               - IndexOutOfBoundsException
               - NullPointerException
               - ClassCastException
               - NegativeArrayException
                 ...
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("0이 아닌 숫자만 입력");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println(num);

        if(num != 0){ // 조건문으로 해결 가능
            System.out.println("나눗셈 결과 : " + 10/num);
        }


    }
}
