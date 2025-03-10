package com.ino.section01.stream;

import com.ino.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {

        Stream<String> fruits = Stream.of("kiwi","apple","banana", "pear");

        int[] arr = {1,2,3,4,5,6,7,8};
        Stream<Integer> num = Arrays.stream(arr).boxed();

        List<Snack> list = List.of(new Snack("muktae", "nongsim", 2000)
                                ,  new Snack("homerun", "lotte", 1500)
                                ,   new Snack("sumi", "lotte", 2500)
                                ,   new Snack("jagalchi", "nongsim", 700));
        Stream<Snack> snacks = list.stream();
        fruits.sorted().forEach(System.out::println);
    }
}
