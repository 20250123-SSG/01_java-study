package com.podoseee.section02.intermediate;

import com.podoseee.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    /*
        ## Stream 가공 ##
        Stream 내의 요소들을 필터링 또는 매핑 등을 이용해서
        원하는 데이터로 만드는 과정 (중계연산)
     */
    public static void main(String[] args) {
        /*
            ## Filtering ##
            Stream<T> filter(Predicate<T> predicate)
         */

        Stream<String> fruits = Stream.of("키위", "사과", "바나나", "배", "복숭아");

        // 과일명이 3글자 이상인 것들만 추리기
        fruits.filter( fruit -> fruit.length() >= 3 )
                .forEach( System.out::println );

        Integer[] arr = {10, 9, 2, 1, 5, 34, 23};
        Stream<Integer> nums = Arrays.stream(arr);

        // 숫자가 짝수인 것들만 추리기
        nums.filter( num -> num % 2 == 0 )
                .forEach(System.out::println);

        List<Snack> snacks = List.of(new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700));
        Stream<Snack> snackStream = snacks.stream();

        // 농심 브랜드 과자만 추리기
        snackStream.filter(snack -> snack.getBrand().equals("농심"))
                .forEach(System.out::println);
    }
}
