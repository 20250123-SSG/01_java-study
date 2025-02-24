package com.inyong.section02.list.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {
        // 현재 존재하는 배열을 List로 변경하고 싶다 이관
        // * Arrays.asList(배열)

        String[] seasonArr = {"봄", "여름", "가을", "겨울"};
        System.out.println(seasonArr);

        List<String> seasonList = Arrays.asList(seasonArr);
        System.out.println("seasonList " + seasonList);

        seasonList.add("사계절");
        seasonList.set(0, "Spring");

        System.out.println("==============");

        List<String> carList = Arrays.asList("gene", "Benz", "BMW");

        System.out.println("==============");

        List<String> hobbyList = List.of("운동", "게임", "영화", "산책");

        /*
        List.of 유의 사항 (조회용)
        unmodifiable list 반환함(수정자체가 불가능한 리스트)
        새로운 요소 추가, 삭제, 변경 모두 안됨
         */

//        hobbyList.add("요리");


    }
}