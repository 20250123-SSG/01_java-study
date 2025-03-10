package com.sotogito.section02.intermediate;

import com.sotogito.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        /**
         * ## Mapping
         * Stream<R> map(Function<T,R> mapper)
         *
         * 1. 스트림 내의 데이터를 특정 형태로 가공해주는 메서드
         * 2. 스트림 내의 데이터들을 순회하면서 전달된 Function apply메서드가 실행됨
         *  -> 반환된 데이터들이 담겨있는 스트림을 반환
         * 3. 해당 메서드 호출시 데이터를 받아 어떤 형태로 반환시킬지 람다식을 전달하면됨
         */

        Stream<Integer> nums = Arrays.stream(new Integer[]{213, 32, 3, 14, 35, 3, 4});
        nums.map(num -> 0)
                .forEach(System.out::println);

        System.out.println("-------------------------------------------");

        Stream<Integer> num2 = Arrays.stream(new Integer[]{213, 32, 3, 14, 35, 3, 4});
        num2.filter(num -> num % 2 != 0)
                .map(num -> num / 2)
                .forEach(System.out::println);

        Stream<Snack> snacks = Stream.of(
                new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700));

        snacks.filter(snack ->  snack.getBrand().equals("농심"))
                .map(Snack::getPrice)
                .forEach(System.out::println);


    }

}
