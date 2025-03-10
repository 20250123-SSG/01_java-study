package com.minkook.section02.intermediate;

import java.util.Arrays;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String [] args){
        /*
            ## 가공처리
            필터링,
         */

        Stream<String> fruits = Stream.of("키위","사과","바나나","배","복숭아");

        fruits.filter(fruit -> fruit.length() >= 3)
                .forEach(System.out::println);

        Integer[] arr = {10,9,2,1,5,34,23,9};
        Stream<Integer> nums = Arrays.stream(arr);

        nums.filter(num -> num % 2 == 0)
                .forEach(System.out::println);
    }
}
