package com.john.section02.list.run;

import java.util.Arrays;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {

        String[] seasonArr = {"Spring", "Summer", "Autumn", "Winter"};

        /*
            Arrays.asList() 유의사항
            Fixed size list(길이변경 불가)
            - 새로운 요소 추가 및 요소 삭제 불가능
            - 기존의 요소를 새로운 요소로 변환하는 것은 가능
        */
        // Arrays.asList()
        List<String> seasonList = Arrays.asList(seasonArr);
        System.out.println(seasonList);

//        seasonList.add("Neo Spring");

        seasonList.set(0, "Neo Spring");
        System.out.println(seasonList);

        System.out.println("=======================");

        List<String> carList = Arrays.asList("Ford", "Maze", "BMW");
        System.out.println(carList);

        System.out.println("=======================");

        /*
            List.of() 유의사항
            - Unmodifiable List (수정이 불가능)
         */
        // List.of()
        List<String> hobbyList = List.of("swimming", "baseball", "soccer");
        System.out.println(hobbyList);

//        hobbyList.add("tennis");
//        hobbyList.remove(2);
//        hobbyList.set(0, "cooking");
    }
}
