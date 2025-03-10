package com.inyong.section02.try_catch_handling;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("배열길이 양수");
            int size = sc.nextInt(); //InputMismatchException 발생 가능

            int[] arr = new int[size]; // NegativeArraySizeException
            System.out.println(Arrays.toString(arr));

            System.out.print("배열의 인덱스(적절한 범위): ");
            int index = sc.nextInt();
            System.out.println(index + arr[index]);
        } catch (InputMismatchException e) {
            System.out.println("0으로 나눌수 없다");
        } catch (RuntimeException e){
            System.out.println("배열과 관련된 문제가 발생");

            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());

            e.printStackTrace(); // 예외상황을 추적해서 출력
        }
        // 여러 예외를 한번에 받아 처리하고자 할 경우 부모 예외클래스 타입으로 작성 가능
        // 단, 순서 유의할 것 (하위 예외클래스 타입이 상위 예외클래스 타입보다 아래에 위치해 있으면 안됨)

        System.out.println("프로그램을 종료합니다.");
    }
}
