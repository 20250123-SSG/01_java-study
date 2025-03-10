package com.ino.section02.intermediate;

import com.ino.dto.Snack;

import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {
        Stream<String> fruits = Stream.of("kiwi","apple","banana", "pear");
        fruits.filter( fruit -> fruit.length() > 4).forEach(System.out::println);

        List<Snack> list = List.of(new Snack("muktae", "nongsim", 2000)
                ,  new Snack("homerun", "lotte", 1500)
                ,   new Snack("sumi", "lotte", 2500)
                ,   new Snack("jagalchi", "nongsim", 700));
        Stream<Snack> snacks = list.stream();

        snacks.filter( snack -> snack.getBrand().equals("nongsim")).forEach(System.out::println);

    }
}
