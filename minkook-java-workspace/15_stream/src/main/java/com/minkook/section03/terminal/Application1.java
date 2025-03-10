package com.minkook.section03.terminal;

import com.minkook.dto.Snack;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application1 {
    public static void main(String [] args) {
        /*
            ## Stream 결과 ##
            가공된 스트림을 최종 결과물로 만들어내는 작업
         */
        
        /*
            calc 
            최소값, 최대값, 총합 평균등과 같은 결과를 도출해내는 메소드들
         */

        // *count() : 요소 개수 반환(long)
        IntStream.range(1, 10);

        long count = IntStream.range(1, 10).count();
        System.out.println("count: " + count);

        // * sum() : 요소의 총합반환
        int sum = IntStream.range(1, 10).sum();
        System.out.println(sum);

        OptionalInt max = IntStream.range(1, 10).max();
        OptionalInt min = IntStream.range(1, 10).min();
        System.out.println(max);
        System.out.println(min);

        List<Snack> list = List.of(new Snack("먹태깡", "농심", 1500),
                new Snack("홈런볼", "롯데", 2000),
                new Snack("홈런볼", "롯데", 2000),
                new Snack("자갈치", "농심", 2000)
        );

        String nongsimName = list.stream()
                .filter(snack -> snack.getOrigin().equals("농심"))
                .map(snack -> snack.getName())
                .collect(Collectors.joining(", "));

        System.out.println(nongsimName);

        List<Snack> list2 = List.of(new Snack("먹태깡", "농심", 1500),
                new Snack("홈런볼", "롯데", 1000),
                new Snack("칙촉", "롯데", 2000),
                new Snack("자갈치", "농심", 2000)
        );

//        String nameList = list.stream()
//                .filter(snack -> snack.getPrice() >= 1000)
//                .map(snack -> snack.getName())
//                //.collect(Collectors.joining(", "));
//                        //.toList();
//        nameList.add("빵부장")
//
//        System.out.println(nameList);

        //브랜드별 그룹핑
        /*
            {
                "농심":[]
         */
        Map<String,List<Snack>> grouping = list.stream()
                .collect(Collectors.groupingBy(snack -> snack.getOrigin()));
        System.out.println(grouping);
    }
}
