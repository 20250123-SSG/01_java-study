package com.kyungbae.section02.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Application3 {
    public static void main(String[] args) {

        // Sorting
        Stream<Integer> nums1 = Arrays.stream(new Integer[]{10,3,5,20,1,4,23});
        // 오름차순 정렬
        nums1.sorted()
                .forEach(System.out::println);

        System.out.println("--------------");

        Stream<Integer> nums2 = Arrays.stream(new Integer[]{10,3,5,20,1,4,23});
        // 내림차순 정렬
//        nums2.sorted(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        }).forEach(System.out::println);

        // 람다식 표현
//        nums2.sorted( (a,b) -> b.compareTo(a)).forEach(System.out::println);

        // 내림차순 정렬 더 쉽게 (Comparator의 reverseOrder 메소드 사용)
        nums2.sorted(Comparator.reverseOrder()).forEach(System.out::println);

    }
}
