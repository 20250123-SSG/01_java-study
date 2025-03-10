package com.ino.section02.try_catch_handling;

import java.util.Arrays;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arrSize : ");
        int size = sc.nextInt();

        try {
            int[] arr = new int[size]; // NegativeArraySizeException
            System.out.println("arr: " + Arrays.toString(arr));

            System.out.println("arr index");
            int index = sc.nextInt();
            System.out.println("Arr[" + index + "]: " + arr[index]); // ArrayIndexOutOfBoundsException
        } catch (RuntimeException e) {
            System.out.println(e.getClass().getName()); // 예외 클래스 타입
            System.out.println(e.getMessage()); // 예외 메시지
        }
        System.out.println("ends program");

    }
}
