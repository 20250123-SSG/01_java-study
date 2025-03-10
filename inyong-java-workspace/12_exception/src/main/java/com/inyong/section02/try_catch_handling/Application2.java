package com.inyong.section02.try_catch_handling;

import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        try {
            System.out.println("0이 아닌 정수");
            int num = Integer.parseInt(sc.nextLine());

            System.out.println("나눗셈 결과 " + 10 / num); //ArithmeticException
        } catch(ArithmeticException e){
            System.out.println("0으로 나눌수 없다");
        } catch (NumberFormatException e){
            System.out.println("정수로 변환 할 수 없음");
        }

        // 다중 catch 블럭 작성 가능 = > 각 예외 상황에 맞게 실행할 구문 작성

        System.out.println("프로그램을 종료합니다.");
    }

}