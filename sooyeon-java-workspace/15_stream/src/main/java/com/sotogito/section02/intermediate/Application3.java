package com.sotogito.section02.intermediate;

import java.util.Comparator;
import java.util.stream.Stream;

public class Application3 {
    public static void main(String[] args) {
        /**
         * ## Sorting
         * Stream<T> sorted()
         * Stream<T> sorted(Comparator<T> cmparator)
         *
         * 1. 스트림 내의 데이터를 정렬시켜 새로운 Stream에 담아 반환
         * 2. 매개변수 없는 sorted는 오름차순으로 자동 정렬
         * 3. 별도의 정렬 기준을 제시하고자 할 경우 Comparator구현 객체를 넘겨 호출
         */

        Stream<Integer> nums1 = Stream.of(1, 2, 3, 4, 5);


        nums1.sorted().forEach(System.out::println);



        nums1.sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        }).forEach(System.out::println);



        nums1.sorted((a, b) -> -a.compareTo(b)).forEach(System.out::println);

    }
}
