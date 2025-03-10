package com.ino.section03.terminal;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
//        Stream<Integer> integerStream = IntStream.range(1, 10).boxed();
//        Integer reduce = integerStream.reduce(Integer::sum);
//        System.out.println("sum : " + reduce);
//
        OptionalInt sum = IntStream.range(1, 4).reduce(Integer::sum);
        System.out.println("sum : " + sum);
        Stream<Integer> nums1 = Arrays.stream(new Integer[]{10,2,1,2,5,34,32});
        nums1.reduce(0, (n1, n2) -> Math.max(n1, n2));
        nums1.reduce(0, Math::max);
    }
}
