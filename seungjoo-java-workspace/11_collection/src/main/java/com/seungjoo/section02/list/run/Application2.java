package com.seungjoo.section02.list.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {

    String[] seasonArr = {"봄", "여름", "가을", "겨울"};
        List<String> seasonList = Arrays.asList(seasonArr);
        System.out.println(seasonList);

        seasonList.set(0,"Spring");
        System.out.println(seasonList);

        List<String> hobbyList = List.of("운동", "게임", "영화", "산책");
        System.out.println("hobbyList: " + hobbyList);

    }
}
