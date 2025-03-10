package com.younggalee.section02.intermediate;

import com.younggalee.dto.Snack;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    /*
        ## Stream 가공 ##
        Stream 내의 요소들을 필터링 또는 매핑 등
        원하는 데이터로 만드는 과정 (중계연산)
     */
    public static void main(String[] args) {
        /*
        ## Filtering ##
        Stream<T> filter(predicate<T> predicate)

        1. 스트림 내의 특정 데이터만 걸러내주는 메소드
        2. 스트림 내의 데이터들을 순회함년서 전달된 Predicate의 test 메소드가 실행됨
           이때, true로 반환되는 데이터만 추려짐
          >> 추려진 데이터들이 다시 새로운 Stream에 담겨 반환됨

         3. 즉, filter 메소드 호출(사용)시, 선별한 데이터에 대한 조건을 true로 반환하는 람다식을 전달하면됨.

         */
        Stream<String> fruits = Stream.of("키위", "사과", "바나나", "배", "복숭아");

        //과일명이 3글자이상인것들만 출력하기
        fruits.filter(fruit -> fruit.length() >= 3).forEach(System.out::println);

        Integer[] arr = {5, 4, 3, 2, 1};
        Stream<Integer> nums = Arrays.stream(arr);
        nums.filter(num -> num%2 == 0).forEach(System.out::println);

        List<Snack> list = List.of(
                new Snack("snack1", "농심",2000)
                , new Snack ("snack2","농심", 5000)
                , new Snack ("snack3","농심", 23000)
                , new Snack ("snack4", "농심",7000)
        );

        //농심 브랜드 과자만 추리기
        Stream<Snack> snackStream = list.stream();
        snackStream.filter(snack -> snack.getBrand().equals("농심")).forEach(System.out::println);

    }
}
