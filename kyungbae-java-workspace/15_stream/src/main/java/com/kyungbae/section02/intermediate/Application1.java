package com.kyungbae.section02.intermediate;

import com.kyungbae.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {

        // Stream 가공
        // Filtering
        // Stream<T> filter(Predicate<T> predicate)
        Stream<String> fruits = Stream.of("사과", "바나나", "배", "복숭아", "파인애플");
        // 과일명이 3글자 이상인 것들만 추리기
        fruits.filter(a -> a.length() >= 3)
                .forEach(System.out::println);

        Integer[] arr = {10,3,5,20,1,4,23};
        Stream<Integer> nums = Arrays.stream(arr);

        // 숫자가 짝수인 것들만 추리기
        nums.filter(a -> a%2==0)
                .forEach(System.out::println);


        List<Snack> list = List.of(
                new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700)
        );
        Stream<Snack> snacks = list.stream();
        // 농심 브랜드 과자만 추리기
        snacks.filter(a -> a.getBrand().equals("농심"))
                .forEach(System.out::println);

    }
}
