package com.john.section03.terminal;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Application2 {
    public static void main(String[] args) {
        // Reducing

        // Optional<T> reduce(BinaryOperator<T> accumulator) (accumulator: 누적자, 두 요소를 전달받고 결합)
        // T reduce(T identity, BinaryOperator<T> accumulator) (identity: 초기값 또는 스트림이 비어있을 때의 기본값

        OptionalInt sum = IntStream.range(1, 4).reduce((x, y) -> x + y); // 내부적으로 값을 계속 받아 계산 진행
        OptionalInt sum2 = IntStream.range(1, 4).reduce((x, y) -> Integer.sum(x, y));
        OptionalInt sum3 = IntStream.range(1, 4).reduce(Integer::sum);

        Stream<Integer> nums = Arrays.stream(new Integer[]{1, 2, 3, 4, 39,5,32,12,48,7});
//        int max = nums.reduce(0, (x, y) -> Math.max(x, y));
        int max2 = nums.reduce(0, Math::max);
    }
}
