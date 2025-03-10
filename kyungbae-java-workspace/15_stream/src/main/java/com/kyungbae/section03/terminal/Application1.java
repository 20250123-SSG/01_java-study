package com.kyungbae.section03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {

        // Stream 결과
        // Calculating

        // count() : 요소 개수 반환 (long타입)
        long count = IntStream.range(1,10).count();
        System.out.println("count: " + count);

        // sum() : 요소들의 총합 반환 (기본타입스트림에서만)
        int sum = IntStream.range(1,10).sum();
        System.out.println("sum: " + sum);

        // max() : 요소들 중 최대값 반환 (OptionalInt타입 => 데이터가 없을경우 반환이 있는 타입)
        // min() : 요소들 중 최소값 반환
        OptionalInt max = IntStream.range(1,10).max();
        OptionalInt min = IntStream.range(1,10).min();
        System.out.println("max: " + max.getAsInt());
        System.out.println("min: " + min.getAsInt());

        // 1부터 10까지의 정수들 중 짝수만의 총합 출력
        int evenSum = IntStream.rangeClosed(1,10)
                               .filter(a -> a%2==0)
                               .sum();
        System.out.println("evenSum: " + evenSum);

    }
}
