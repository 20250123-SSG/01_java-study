package com.podoseee.section02.try_catch_handling;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("배열의 길이(양수): ");
            int size = sc.nextInt(); // InputMismatchException 발생 가능

            int[] arr = new int[size]; // NegativeArraySizeException 발생 가능
            System.out.println("arr : " + Arrays.toString(arr));

            System.out.print("배열의 인덱스(적절한범위): ");
            int index = sc.nextInt(); // InputMismatchException 발생 가능
            System.out.println("arr[" + index + "]: " + arr[index]); // ArrayIndexOutOfBoundsException 발생 가능
        }catch(InputMismatchException e){
            System.out.println("타입에 맞는 값을 입력하셔야됩니다.");
        }catch(RuntimeException e){ // 부모타입 예외클래스 => 자식예외객체 다 수용 가능
            System.out.println("배열과 관련된 문제가 발생되었습니다.");

            System.out.println("exception class : " + e.getClass().getName()); // 예외클래스타입
            System.out.println("exception message : " + e.getMessage());       // 예외메세지

            e.printStackTrace();
        }

        // 여러 예외를 한 번에 받아 처리하고자 할 경우 부모 예외클래스 타입으로 작성 가능
        // 단, 순서 유의할 것 (하위 예외클래스 타입이 상위 예외클래스 타입보다 아래에 위치해 있으면 안됨)

        System.out.println("프로그램을 종료합니다.");

    }
}
