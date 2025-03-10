package com.sotogito.section03.terminal;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        /**
         * Reducing
         * 요소들을 하나의 결과물로 줄여나감
         * 누적자(accumulator)를 사용해서 중간중간 연산을 수행시킴
         *
         * 1.Optional<T> reduce(BinaryOperator<T> accumulator)
         *          accumulator : 두 요소를 결합하는 함수
         * 2. reduce(T identity, BinaryOperator<T> accumulator)
         *          identity : 초기값 또는 스트림이 비어있을 때의 기본값
         *
         */


        OptionalInt result = IntStream.range(1, 4).reduce(Integer::sum);


        Stream<Integer> nums = Arrays.stream(new Integer[]{235, 23, 5, 56, 51, 7, 345});
        int max = nums.reduce(0, Math::max); //0은 초기값
        System.out.println(max);

    }
}
