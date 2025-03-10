package com.inyong.section01.exception;

import java.util.Arrays;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("배열 길이: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("arr" + Arrays.toString(arr));

        System.out.println("배열 인덱스");
        int index = sc.nextInt();
        System.out.println(index + " " + arr[index]); // ArrayIndexOutOfBoundsException

        System.out.println("프로그램을 종료합니다.");



    }
}
