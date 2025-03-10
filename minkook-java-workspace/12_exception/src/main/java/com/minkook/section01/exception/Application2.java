package com.minkook.section01.exception;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Application2 {
    // 예외상황2 사용자에게 배열의 길이를 입력받아 배열 생성 => 출력시킬 인덱스 수도 입력받아 출력


    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("배열길이: ");
        int size = sc.nextInt();

        int [] arr= new int[size];
        System.out.println("arr: " + Arrays.toString(arr));

        System.out.println("배열 인덱스: ");
        int index = sc.nextInt();
        System.out.println("arr[" + index + "]" + arr[index]); //ArrayIndexOutOFBoundsException 발생가능

        System.out.println("프로그램을 종료합니다.");

    }
}
