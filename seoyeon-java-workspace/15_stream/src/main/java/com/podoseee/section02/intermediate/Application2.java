package com.podoseee.section02.intermediate;

import com.podoseee.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        /*
            ## Mapping ##
            Stream<R> map(Function<T, R> mapper)

         */

        //Integer[] arr = {10, 9, 2, 1, 5, 34, 23};
        Stream<Integer> nums1 = Arrays.stream(new Integer[]{10, 9, 2, 1, 5, 34, 23}); // 어딘가에 전달할 때에는 생성구문 필요함 : new Integer[]
        // 2배 증가시킨 데이터
        nums1.map(num -> num * 2)
                .forEach(System.out::println);

        System.out.println("====");

        Stream<Integer> nums2 = Arrays.stream(new Integer[]{10, 9, 2, 1, 5, 34, 23});
        // 홀수 데이터만 2배감소(/2)시킨 데이터
        nums2.filter(num -> num % 2 == 1) // [9, 1, 5, 23]
                .map(num -> num / 2)      // [4, 0, 2, 11]
                .forEach(System.out::println);

        System.out.println("=========================");

        Stream<Snack> snacks = List.of(new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700)).stream();

        // 농심 브랜드 과자의 가격들만
        snacks.filter(snack -> snack.getBrand().equals("농심")) // [new Snack("먹태깡", "농심", 2000), new Snack("자갈치", "농심", 700)]
                .map(snack -> snack.getPrice()) // [2000, 700]
                .forEach(System.out::println);

    }
}
