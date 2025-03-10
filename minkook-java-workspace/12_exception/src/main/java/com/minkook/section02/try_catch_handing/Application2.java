package com.minkook.section02.try_catch_handing;

import java.util.Scanner;

public class Application2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("0이 아닌 정수만: ");
        try {
            int num = Integer.parseInt(sc.nextLine());

            System.out.println("나눗셈결과: " + 10/num);

            System.out.println("프로그램을 종료합니다.");
        }catch (ArithmeticException e){
            System.out.println("0으로 나눌수 없습니다.");
        }catch (NumberFormatException e){
            System.out.println("정수로 변환할 수 없는 값을 입력하셨습니다.");
        }
        
        //다중 catch 블럭 작성 가능 -> 각 예외에 맞게 실행할 구문 작성
        System.out.println("프로그램을 종료합니다.");
    }
}
