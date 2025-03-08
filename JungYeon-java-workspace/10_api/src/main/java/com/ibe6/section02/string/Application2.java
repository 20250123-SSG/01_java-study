package com.ibe6.section02.string;

import java.util.StringTokenizer;

public class Application2 {
    public static void main(String[] args) {

        String str = "Java,MySQL,MyBatis,Front,Spring";

        // 문자열 분리 시키는 방법
        // 방법1. 분리된 문자열들을 String[]로 담아 관리하고자 할 경우 => split() 메소드 사용
        //        문자열.split("구분자") : String[]
        String[] arr = str.split(",");
        System.out.println("분리된 문자열의 개수: " + arr.length);
        for(int i=0; i<arr.length; i++){
            System.out.println(i + "번째 인덱스: " + arr[i]);
        }

        System.out.println("=============");


        // 방법2. 분리된 문자열들을 토큰으로 관리하고자 할 경우 => java.util.StringTokenizer 사용
        //        StringTokenizer 변수 = new StringTokenizer("문자열", "구분자");
        //        단, StringTokenizer 객체 내에 담긴 분리된 문자열은 한번 꺼내쓰면 끝 (일회성)
        StringTokenizer stn = new StringTokenizer(str, ",");
        System.out.println("분리된 문자열의 개수(토큰의 개수): " + stn.countTokens());

        /*
        System.out.println(stn.nextToken());
        System.out.println(stn.nextToken());
        System.out.println(stn.nextToken());
        System.out.println(stn.nextToken());
        System.out.println(stn.nextToken());
        System.out.println(stn.countTokens()); // NoSuchElementException 발생 (더이상의 요소가 없습니다)
        */

        // 토큰의 개수만큼 반복문을 통해 각 토큰 출력
        for(int i=0; i<stn.countTokens(); i++){
            System.out.println(stn.nextToken());
        }
        // i=0 i<5 true "Java" i++
        // i=1 i<4 true "MySQL" i++
        // i=2 i<3 true "MyBatis" i++
        // i=3 i<2 false

        // 해결방법1.
        /*
        int count = stn.countTokens(); // count = 5;
        for(int i=0; i<count; i++){
            System.out.println(stn.nextToken());
        }
         */

        // 해결방법2.
        while (stn.hasMoreTokens()){
            System.out.println(stn.nextToken());
        }


    }
}
