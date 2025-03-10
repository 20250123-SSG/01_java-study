package com.sotogito.section03.terminal;

import com.sotogito.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application3 {
    public static void main(String[] args) {
        /**
         * ## Collecting
         * 요소들을 수집해서 원하는 형태(문자열, 컬렉션)으로 반환해주는 기능
         */

        Stream<Snack> snacks = Stream.of(
                new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700));

        String reuslt = snacks.filter(s -> s.getBrand().equals("농심"))

                .map(Snack::getName)

                .collect(Collectors.joining(", "))

                .trim();

        System.out.println(reuslt);


        //가격이 1,000원 이상인 과자명들을 리스트로
        List<String> names = snacks.filter(s -> s.getPrice() >= 1000)
                .map(Snack::getName)
                .collect(Collectors.toList());


        List<Snack> list = Arrays.asList (
                new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700));

        /// 그룹핑
        /**
         * {
         *      "농심" : [ new Snack("먹태깡", "농심", 2000),
         *                 new Snack("자갈치", "농심", 700) ],
         *      "롯데" :  [  new Snack("홈런볼", "롯데", 1500),
         *                   new Snack("수미칩", "롯데", 2500) ],
         * }
         * - key-value의 형태
         *
         * Map{ key(String) : value(List<Snack>), ...}
         */

        Map<String, List<Snack>> grouping = list.stream()
                .collect(Collectors.groupingBy(snack -> snack.getBrand()));


    }
}
