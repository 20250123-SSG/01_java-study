package com.minkook.section03.terminal;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String [] args){

        OptionalInt sum = IntStream.range(1,4)
                                .reduce((a,b) -> a + b);

        System.out.println(sum.getAsInt());


        Stream<Integer> nums = Arrays.stream(new Integer[]{10,9,2,1,5,34,23});

        int max = nums.reduce(0,Math::max);
        System.out.println("max: " + max);



    }
}
