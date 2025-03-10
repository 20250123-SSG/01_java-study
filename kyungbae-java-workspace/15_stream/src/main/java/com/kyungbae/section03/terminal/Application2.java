package com.kyungbae.section03.terminal;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {

        // Reducing
        // 1. Optional<T> reduce(BinaryOperator<T> accumulator) // accumulator : 두 요소를 결합하는 함수
        // 2. reduce(T identity, BinaryOperator<T> accumulator) // identity : 초기값 또는 기본값

        // 총합
        OptionalInt sum = IntStream.range(1,4)
//                .reduce((a,b)->a+b);
                .reduce(Integer::sum);
        System.out.println("sum: " + sum.getAsInt());

        // 최대값
        Stream<Integer> nums = Arrays.stream(new Integer[]{10,3,5,20,1,4,23});
        int numMax = nums.reduce(0, Math::max);
        System.out.println("MAX: " + numMax);


    }
}
