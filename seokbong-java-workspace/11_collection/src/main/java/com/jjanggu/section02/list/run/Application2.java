package com.jjanggu.section02.list.run;


import java.util.Arrays;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {

        // 현재 존재하는 배열을 List로 이관(변환)하고 싶을 경우

        // * Arrays.asList(배열) : 인자로 전달된 배열의 요소들을 List에 담아 반환
        String[] seasonArr = {"봄", "여름", "가을", "겨울"};
        List<String> seasonList = Arrays.asList(seasonArr);
        System.out.println("seasonList : " + seasonList);

        /*
            * Arrays.asList 유의사항
              fixed-size list 반환함 (길이 변경이 불간으한 리스트)
              새로운 요소 추가 및 요소 삭제 불가능
              단, 기존의 요소를 새로운 요소로 변경은 가능
         */
//        seasonList.add("사계절"); //UnsupportedOperationException 발생

        // * set(int index, E e) : 인자로 전달된 인덱스 위치의 요소를 새로이 전달된 요소로 변경
        seasonList.set(0, "Spring");
        System.out.println("seasonList : " + seasonList);

        System.out.println("=================================================");

        // * Arrays.asList(요소, 요소, 요소, ...) : 인자로 전달된 요소들을 List에 담아서 반환
        List<String> carList = Arrays.asList("Genesis", "Benz", "BMW");
        System.out.println("carList : " + carList);

        System.out.println("==============================================");

        // * List.of(요소, 요소, 요소, ...) : 해당 요소들이 담겨있는 List를 반환
        List<String> hobbyList = List.of("운동", "게임", "영화", "산책");
        System.out.println("hobbyList : " + hobbyList);

        /*
            * List.of 유의사항
              unmodified list 반환함 (수정 자체가 불가능한 리스트)
              새로운 요소 추가, 삭제, 변경 모두 안됨
         */

        //hobbyList.add("요리");
        //hobbyList.add(1);
        //hobbyList.add(0,"요리");
    }
}
