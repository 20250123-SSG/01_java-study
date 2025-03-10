package com.sotogito.section03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
    /**
     * ## Stream 결과
     * 가공된 스트림을 최종 결과물로 만들어내는 작업
     */

    public static void main(String[] args) {
        /**
         * Calculating
         * 최소,최대,홍합, 편균등과 같은 결과를 도출해내는 메서드
         */

        /// count() : 요소 개수 반환 - long타입
        long count = IntStream.range(1, 10).count();
        System.out.println(count); //9

        /// sum() : 요소들의 총 합을 반환 - 기본타입Stream에서만 제공
        int sum = IntStream.range(1, 10).sum();
        System.out.println(sum);//45

        /// max
        /// min
        OptionalInt max = IntStream.range(1, 10).max();
        OptionalInt min = IntStream.range(1, 10).min();

        if (max.isPresent()) {
            int maxInt = max.getAsInt();
        }


        int sumResult = IntStream.rangeClosed(1, 10)
                .filter(num -> num % 2 == 0)
                .sum();

    }

}
