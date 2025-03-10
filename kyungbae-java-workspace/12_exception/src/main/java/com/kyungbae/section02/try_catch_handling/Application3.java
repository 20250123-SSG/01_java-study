package com.kyungbae.section02.try_catch_handling;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("배열의 길이(양수): ");
            int size = sc.nextInt(); // InputMismatchException 발생 가능 (다른 타입 작성시)

            int[] arr = new int[size]; // NegativeArraySizeException 발생 가능 (음수 입력시)
            System.out.println("arr: " + Arrays.toString(arr));

            System.out.print("배열의 인덱스(적절한 범위): ");
            int index = sc.nextInt(); // InputMismatchException 발생 가능 (다른 타입 작성시)

            System.out.println("arr[" + index + "]" + arr[index]); // ArrayIndexOutOfBoundsException 발생 가능 (배열의 범위를 넘어갈시)
        } catch (InputMismatchException e) {
            System.out.println("타입에 맞는 값을 입력해주세요");
        } catch (RuntimeException e) { // 부모타입 예외클래스 => 자식예외객체 다 수용 가능
            System.out.println("잘좀..");

            System.out.println("exception class: " + e.getClass().getName()); // 예외클래스타입
            System.out.println("exception message: " + e.getMessage()); // 예외메세지

            e.printStackTrace();
        }
        System.out.println("프로그램 종료");
    }
}
