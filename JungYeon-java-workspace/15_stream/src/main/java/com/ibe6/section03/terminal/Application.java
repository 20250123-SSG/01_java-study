package com.ibe6.section03.terminal;

import javax.swing.text.html.Option;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application {
    /*
        ## Stream 결과 ##
        가공된 스트림을 최종 결과물로 만들어내는 작업
     */
    public static void main(String[] args) {
        /*
            ## Calculating ##
            최소값, 최대값, 총합, 평균 등과 같은 결과를 도출해내는 메소드들
         */

        // * count() : 요소 개수 반환 (long타입)
        long count = IntStream.range(1, 10).count();
        System.out.println("count: " + count);

        // * sum() : 요소의 총합 반환 (기본타입스트림에서만 제공)
        int sum = IntStream.range(1, 10).sum();
        System.out.println("sum: " + sum);

        // * max() : 요소의 최대값 반환
        // * min() : 요소의 최소값 반환
        OptionalInt max = IntStream.range(1, 10).max();
        OptionalInt min = IntStream.range(1, 10).min();
        System.out.println("max: " + max.getAsInt());
        System.out.println("min: " + min.getAsInt());

        // 실습. 1부터 10까지의 정수들 중 짝수만의 총합구하기.
        int evenSum = IntStream.rangeClosed(1, 10)
                .filter(num -> num % 2 == 0)
                .sum();
        System.out.println("evenSum: " + evenSum);






    }
}
