package com.ino.section02.intermediate;

import com.ino.dto.Snack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Application3 {
    public static void main(String[] args) {
        Stream<Integer> nums1 = Arrays.stream(new Integer[]{10,2,1,2,5,34,32});
        nums1.sorted((o1, o2) -> o2.compareTo(o1)).forEach(System.out::println);
        Stream<Snack> snacks = List.of(new Snack("muktae", "nongsim", 2000)
                ,  new Snack("homerun", "lotte", 1500)
                ,   new Snack("sumi", "lotte", 2500)
                ,   new Snack("jagalchi", "nongsim", 700)).stream();
//        snacks.sorted(new Comparator<Snack>() {
//            @Override
//            public int compare(Snack o1, Snack o2) {
//                return o2.getName().charAt(0) - o1.getName().charAt(0);
//            }
//        }).forEach(System.out::println);
        Stream<Integer> nums2 = Arrays.stream(new Integer[]{10,2,1,2,5,34,32});
        Stream<Integer> integerStream = nums2.sorted(((o1, o2) -> o2 - o1));
    }
}
