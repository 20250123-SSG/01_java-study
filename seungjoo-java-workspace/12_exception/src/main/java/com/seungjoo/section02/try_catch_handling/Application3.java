package com.seungjoo.section02.try_catch_handling;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("배열의 길이(양수)");
            int size = sc.nextInt(); //InputMissMatchException 발생 가능


            int[] arr = new int[size];
            System.out.println(Arrays.toString(arr));

            System.out.println("배열의 인덱스(적절한 범위)");
            int index = sc.nextInt();
            System.out.println(arr[index]); //ArrayIndexOutOfBounds 발생 가능
        }catch(InputMismatchException e) {
            System.out.println("타입에 맞는 값을 입력하셔야 됩니다.");
        }catch (RuntimeException e) {
            System.out.println("배열과 관련된 문제가 발생되었습니다.");
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());

            e.printStackTrace(); //예외상황을 추적해서 출력
        }
    }
}
