package com.minkook.section02.try_catch_handing;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application3 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);


        try {
            System.out.print("배열의 길이(양수): ");
            int size = sc.nextInt();

            int[] arr = new int[size]; //NegativeArraySizeException 발생가능
            System.out.println("arr: " + Arrays.toString(arr));

            System.out.print("배열의 인덱스(적절한 범위): ");
            int index = sc.nextInt();
            System.out.println("arr[" + index + "]:" +arr[index]); //ArrayIndexOutException
        }catch (InputMismatchException e){
            System.out.println("타입에 맞는값을 입력하세요");
        }catch (RuntimeException e){
            System.out.println("배열과 관련된 문제가 발생되었습니다.");
            System.out.println("exception class " + e.getClass().getName());
            System.out.println("exception message " + e.getMessage());

            e.printStackTrace(); //예외상황을 추적해서 출력
        }
        //여러 예외를 한번에 받아 처리하고자 할 경우 부모 예외클래스타입으로 작성 가능
        //단, 순서 유의할것 (하위 예외클래스 타입이 상위 예외클래스 타입보다 아래에 위치해 있으면 안됨)
        System.out.println("프로그램을 종료합니다.");

    }
}
