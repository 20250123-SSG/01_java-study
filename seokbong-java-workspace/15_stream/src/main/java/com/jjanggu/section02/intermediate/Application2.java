package com.jjanggu.section02.intermediate;

import com.jjanggu.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        /*
            ## Mapping

           Stream<R> map(Function<T, R> mapper)

           1. 스트림 내의 데이터를 특정 형태로 가공해주는 메소드
           2. 스트림 내의 데이터들을 순회하면서 전달된 Function의 apply메소드가 실행됨
              => 이때 반환된 데이터들이 담겨있는 Stream을 반환
           3. 즉, 해당 메소드 호출시 데이터를 받아 어떤 형태로 반환시킬껀지 람다식을 전달하면됨
         */

        Stream<Integer> nums1 = Arrays.stream(new Integer[]{10, 9, 2, 1, 5, 34, 23} );
        // 2배 증가시킨 데이터
        nums1.map(num -> num * 2)
                .forEach(System.out::println);

        System.out.println("============================");

        Stream<Integer> nums2 = Arrays.stream(new Integer[]{10, 9, 2, 1, 5, 34, 23} );
        // 홀수 데이터만 2배 감소(/2)시킨 데이터
        nums2.filter(num -> num % 2 ==1 )
                .map(num -> num/2)
                .forEach(System.out::println);

        System.out.println("====================");

        Stream<Snack> snacks = List.of(new Snack("먹태깡", "농심", 2000)
                                , new Snack("홈런볼", "롯데", 1500)
                                , new Snack("수미칩", "롯데", 2500)
                                , new Snack("자갈치", "농심", 700)).stream();

        // 농심 브랜드 과자의 가격들만

        snacks.filter(snack -> snack.getBrand().equals("농심"))
                .map(snack -> snack.getPrice()) // [2000, 700]
                .forEach(System.out::println);


    }
}
