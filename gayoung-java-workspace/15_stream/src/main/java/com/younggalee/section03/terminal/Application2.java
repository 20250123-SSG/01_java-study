package com.younggalee.section03.terminal;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        /*
            ## Reducing ##
            reduce() 메소드를 활용해서 요소들을 하나의 결과로 줄여나가는 연산을 수행
            누적자(accumulator)를 사용해서 중간중간 연산을 수행시킴

            1. Optional<T> reduce(BinaryOperator<T> accumulator)    // accumulator: 두 요소를 결합하는 함수
            2. T reduce(T identity, BinaryOperator<T> accumulator)  // identity : 초기값 또는 스트림이 비어있을 때의 기본값
         */

        // 총합
        OptionalInt sum =  IntStream.range(1, 4) // [1, 2, 3]
                //.reduce((a, b) -> a + b);
                //.reduce((a, b) -> Integer.sum(a, b));
                .reduce(Integer::sum);
        System.out.println("sum: " + sum.getAsInt());

        // 최대값
        Stream<Integer> nums = Arrays.stream(new Integer[]{10, 9, 2, 1, 5, 34, 23});
        //int max = nums.reduce(0, (a, b) -> Math.max(a, b));
        int max = nums.reduce(0, Math::max);
        System.out.println("max: " + max);


    }
}
