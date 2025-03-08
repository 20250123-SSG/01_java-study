package com.podoseee.section02.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Application3 {
    public static void main(String[] args) {
        /*
            ## Sorting ##
            Stream<T> sorted()
            Stream<T> sorted(Comparator<T> comparator)

            1. 스트림 내의 데이터를 정렬시켜 새로운 Stream에 담아 반환
            2. 매개변수 없는 sorted는 오름차순으로 자동 정렬
            3. 별도의 정렬기준을 제시하고자 할 경우 Comparator 구현객체를 넘겨서 호출
         */

        Stream<Integer> nums1 = Arrays.stream(new Integer[]{10, 9, 2, 1, 5, 34, 23});
        // 오름차순 정렬
        nums1.sorted()
                .forEach(System.out::println);

        System.out.println("==");

        Stream<Integer> nums2 = Arrays.stream(new Integer[]{10, 9, 2, 1, 5, 34, 23});
        // 내림차순 정렬
        /*
        nums2.sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        }).forEach(System.out::println);
        */
        nums2.sorted( (num1, num2) -> Integer.compare(num2, num1) )
                .forEach(System.out::println);
    }
}
