package com.jjanggu.section02.try_catch_handling;

import java.util.Scanner;

public class Applcation1 {
    /*
        ## 예외처리 ##
        1. try~catch문 (예외처리)

        2. throw       (예외회피)

        ## try ~ catch문 ##
        발생되는 예외를 직접 처리하는 예외처리 발법
        - 예외가 발생될 수 있는 무
        - 예외 발생시 처리할 구문을 catch 블럭에 작성
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("0이 아닌 정수: ");
        int num = sc.nextInt();

        try{
            System.out.println("나눗셈 결과 : " + 10 / num); //  발생 가능
        }catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
