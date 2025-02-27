package com.john.section02.try_catch_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] arr = new int[5];
            System.out.print("배열의 인덱스(적절한 범위): ");
            int index = sc.nextInt();
            System.out.println("arr[" + index + "]" + arr[index]);
        }catch(InputMismatchException e){
            System.out.println("타입에 맞는 값을 입력하셔야 합니다.");
        }catch (RuntimeException e){ // RuntimeException : 부모타입 예외 클래스=> 자식 예외객체 전부 수용 가능
            System.out.println("배열과 관련된 문제가 발생하였습니다.");

            System.out.println("exception: " + e.getClass().getName());
            System.out.println("exception message: " + e.getMessage());
            // 예외 상황을 추척
            e.printStackTrace();
        }
        System.out.println("프로그램을 종료합니다");
    }
}
