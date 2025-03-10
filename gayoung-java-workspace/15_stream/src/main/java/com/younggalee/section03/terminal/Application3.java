package com.younggalee.section03.terminal;
import com.kangbroo.dto.Snack;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {

        /*
            ## Collecting ##
            요소들을 수집해서 원하는 형태(문자열, 컬렉션 등)로 반환해주는 기능
         */

        List<Snack> list = List.of(new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700));

        // 농심 브랜드의 과자명들을 하나의 문자열로 처리
        String nongsimName = list.stream() // [Snack, Snack, ..]
                .filter(snack -> snack.getBrand().equals("농심")) // [Snack, Snack]
                .map(snack -> snack.getName()) // ["먹태깡", "자갈치"]
                //.collect(Collectors.joining());
                //.collect(Collectors.joining(", ")); // delim
                .collect(Collectors.joining(" || ", "**", "**")); // delim, prefix, suffix

        System.out.println(nongsimName);

        // 가격이 1000원 이상인 과자명들을 리스트로
        List<String> nameList = list.stream()
                .filter(snack -> snack.getPrice() >= 1000)
                .map(snack -> snack.getName())
                .collect(Collectors.toList()); // Mutable List => 가변
        //.toList(); // Immutable List => 불변

        nameList.add("빵부장");
        System.out.println(nameList);

        System.out.println("==========================");

        // 브랜드별 그룹핑
        /*
            {
                "농심": [new Snack("먹태깡", "농심", 2000),
                         new Snack("자갈치", "농심", 700)],
                "롯데": [new Snack("홈런볼", "롯데", 1500),
                         new Snack("수미칩", "롯데", 2500)]
            }

            Map{ key(String):value(List<Snack>), .. }
         */

        Map<String, List<Snack>> grouping = list.stream()
                .collect(Collectors.groupingBy(snack -> snack.getBrand()));

        System.out.println(grouping);

    }
}