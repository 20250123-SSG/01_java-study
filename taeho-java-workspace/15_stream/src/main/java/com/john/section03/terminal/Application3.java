package com.john.section03.terminal;

import com.john.dto.Snack;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {
        // Collecting: 요소들을 원하는 형태로 반환

        List<Snack> list = List.of(new Snack("포카칩", "SKT", 2000)
                , new Snack("초코비","삼양",3000)
                , new Snack("자갈치", "부산", 6500)
                , new Snack("맛동산", "농심", 700)
                , new Snack("김튀김", "농심", 1700));

        String result = list.stream() //[Snack, Snack...]
                .filter(snack -> snack.getBrand().equals("농심")) //[Snack중 농심만, Snack중 농심만...]
                .map(snack -> snack.getName()) // [가져온 Snack의 이름]
//                .collect(Collectors.joining());
//                    .collect(Collectors.joining(", "));
                    .collect(Collectors.joining(" || ", "**", "&&"));
        System.out.println(result);

        List<String> result2 = list.stream()
                .filter(snack -> snack.getPrice() >= 1000)
                .map(snack -> snack.getName())
                .collect(Collectors.toList()); // 가변
//                .toList(); // 불변

        result2.add("오오오");

        System.out.println(result2);

        System.out.println("===================================");

        // Grouping
        Map<String, List<Snack>> grouping = list.stream()
                .collect(Collectors.groupingBy(snack -> snack.getBrand()));

        System.out.println(grouping);

    }
}
