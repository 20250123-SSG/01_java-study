package com.sotogito.section02.intermediate;

import com.sotogito.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    /**
     * ## Stream 가공
     * 스트림 내의 요소들을 필터링 또는 매필등
     * 원하는 데이터로 만드는 과정- 중계연산
     */

    public static void main(String[] args) {
        /**
         * ## Filtering
         * Stream<T> filter(Predicate<T> predicate)
         *
         * 1. 스트림 내의 특정 데이터만 걸러주는 메서드
         * 2. 스트림 내의 데이터를 순회하면서 전달된 Predicate의 test메서드가 실행됨 - true데이터만 추려짐
         *  => 추려지면 다시 새로운 Stream에 담겨 반환됨
         */

        Stream<String> fruits = Stream.of("apple", "banana", "orange", "e");
        fruits.filter(fruit -> fruit.length() >= 3)
                .forEach(System.out::println);

        Integer[] array = {1, 2, 3, 4, 5};
        Arrays.stream(array).filter(num -> num % 2 == 0)
                .forEach(System.out::println);


        List<Snack> snacks = List.of(
                new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700));

        List<Snack> lotte = snacks.stream()
                .filter(snack -> snack.getBrand().equals("롯데"))
                .toList();
        lotte.forEach(System.out::println);
    }
}
