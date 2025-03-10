package com.kyungbae.section02.intermediate;

import com.kyungbae.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {

        // Mapping
//        Integer[] arr = {10,3,5,20,1,4,23};
        Stream<Integer> nums1 = Arrays.stream(new Integer[]{10,3,5,20,1,4,23});
        // 2배 증가시킨 데이터
        nums1.map(a -> a*2)
                .forEach(a -> System.out.print(a + " "));
        System.out.println();

        System.out.println("-----------------------");
        Stream<Integer> nums2 = Arrays.stream(new Integer[]{10,3,5,20,1,4,23});
        // 홀수 데이터만 1/2감소시킨 데이터
        nums2.filter(a -> a%2==1)
                .map(a -> a/2)
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        System.out.println("-----------------------");

        List<Snack> list = List.of(
                new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700)
        );
        Stream<Snack> snacks = list.stream();
        // 농심 브랜드 과자만 추리기
        snacks.filter(a -> a.getBrand().equals("농심"))
                .map(Snack::getPrice)
                .forEach(System.out::println);

    }
}
