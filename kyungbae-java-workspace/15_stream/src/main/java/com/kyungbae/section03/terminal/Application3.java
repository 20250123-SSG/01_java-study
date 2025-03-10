package com.kyungbae.section03.terminal;

import com.kyungbae.dto.Snack;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {

        // Collecting

        List<Snack> list = List.of(
                new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700)
        );

        // 농심 브랜드의 과자명들을 하나의 문자열
        String nongsimName = list.stream()
                .filter(a -> a.getBrand().equals("농심"))
                .map(Snack::getName)
                .collect(Collectors.joining(" || ", "**", "**"));
//                .collect(Collectors.joining())
//                .collect(Collectors.joining(", "))

        System.out.println(nongsimName);

        // 가격이 1000원 이상인 과자명들을 리스트로
        List<String> nameList = list.stream()
                .filter(a -> a.getPrice() >= 1000)
                .map(Snack::getName)
//                .toList(); // => immutable list : 불변 리스트
                .collect(Collectors.toList()); // Mutable list => 확장 가능

        nameList.add("빵부장");
        System.out.println(nameList);

        System.out.println("------------------------------------");

        // 브랜드별 그룹화
        Map<String, List<Snack>> grouping = list.stream()
                .collect(Collectors.groupingBy(Snack::getBrand));

        System.out.println(grouping);


    }
}
