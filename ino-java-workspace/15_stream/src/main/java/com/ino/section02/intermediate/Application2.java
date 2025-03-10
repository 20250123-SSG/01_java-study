package com.ino.section02.intermediate;

import com.ino.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        Stream<Integer> nums = Arrays.stream(arr).boxed();

        Stream<Integer> nums1 = Arrays.stream(new Integer[]{10,2,1,2,5,34,32});

        Stream<Integer> nums2 = nums1.map(num -> num *= 2);

        Stream<Snack> snacks = List.of(new Snack("muktae", "nongsim", 2000)
                ,  new Snack("homerun", "lotte", 1500)
                ,   new Snack("sumi", "lotte", 2500)
                ,   new Snack("jagalchi", "nongsim", 700)).stream();

        snacks.filter( snack -> snack.getBrand().equals("nongsim")).forEach( snack -> System.out.println(snack.getPrice()));



    }
}
