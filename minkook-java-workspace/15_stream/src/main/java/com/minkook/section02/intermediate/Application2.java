package com.minkook.section02.intermediate;

import com.minkook.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String [] args){
        Stream<Integer> nums1 = Arrays.stream(new Integer[]{10,9,2,1,5,34,23});
        //2배 증가시킨 데이터
        nums1.map(num -> num * 2)
                .forEach(System.out::println);

        System.out.println("====");

        Stream<Integer> nums2 = Arrays.stream(new Integer[]{10,9,2,1,5,34,23});

        nums2.filter(num -> num % 2 == 1)
                .map(num -> num / 2)
                .forEach(System.out::println);

        Stream<Snack> snacks = List.of(new Snack("먹태깡","농심",1500),
                new Snack("홈런볼","롯데",2000),
                new Snack("홈런볼","롯데",2000)).stream();




        snacks.filter(snack -> snack.getOrigin().equals("농심"))
                .map(snack -> snack.getPrice())
                .forEach(System.out::println);

    }
}
