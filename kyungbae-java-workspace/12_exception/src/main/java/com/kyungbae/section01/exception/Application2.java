package com.kyungbae.section01.exception;

import java.util.Arrays;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        // 예외상황2. 사용자에게 배열의 길이를 입력받아 배열 생성 => 출력시킬 인덱스수도 입력받아 출력
        Scanner sc = new Scanner(System.in);

        System.out.print("배열 길이(양수): ");
        int size = sc.nextInt();

        int[] arr = new int[size]; // NegativeArraySizeException 발생 가능성 (-3 // 음수 입력 시)
        System.out.println("arr: " + Arrays.toString(arr));

        System.out.print("배열 인덱스(적절한 범위): ");
        int index = sc.nextInt();

        System.out.println("arr[" + index + "]:" + arr[index]);
        // ArrayIndexOutOfBoundsException 발생 가능성
        // Index 10 out of bounds for length 10 => 10 입력 시

        System.out.println("프로그램종료");
    }
}
