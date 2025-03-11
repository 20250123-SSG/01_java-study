package com.ibe6.section02.intermediate;

import com.ibe6.dto.Snack;

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
            filter(Predicate<T> predicate)

            1. 스트림 내의 특정 데이터만 걸러내주는 메소드
            2. 스트림 내의 데이터들을 순회하면서 전달된 Predicate의 test메소드가 실행됨
               이때 true로 반환되는 데이터만 추려짐
               => 추려진 데이터들이 다시 새로운 Stream에 담겨 반환됨
            3. 즉, 해당 메소드 호출시 선별할 데이터에 대한 조건을 ture로 반환하는 람다식을 전달하면됨
         */

        Stream<String> fruits = Stream.of("키위", "사과", "바나나", "배", "복숭아");

        // 과일명이 3글자 이상인 것들만 추리기
        fruits.filter( fruit -> fruit.length() >= 3 )
                .forEach(System.out::println );


        Integer[] arr = {10, 9, 2, 1, 5, 34, 23};
        Stream<Integer> nums = Arrays.stream(arr);

        // 숫자가 짝수인 것들만 추리기
        nums.filter( num -> num % 2 == 0 )
                .forEach(System.out::println);


        List<Snack> list = List.of(
                  new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700));
        Stream<Snack> snacks = list.stream();

        // 농심 브랜드 과자만 추리기

        snacks.filter(snack -> snack.getBrand().equals("농심"))
                .forEach(System.out::println);


    }
}