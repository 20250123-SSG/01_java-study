package com.sotogito.section03;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Practice {
    public static void main(String[] args) {
//        Consumer<LocalTime> timeFormatter =
//                time -> System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss").format(time));
//
//        timeFormatter.accept(LocalTime.now());
//
//        Supplier<Set<Integer>> lottoNumberMaker = () -> {
//            TreeSet<Integer> lottoNumbers = new TreeSet<>(); //로또 오름차순
//            while (lottoNumbers.size() < 6) {
//                lottoNumbers.add((int) (Math.random() * 45 + 1));
//            }
//            return lottoNumbers;
//        };
//        System.out.println(lottoNumberMaker.get());
//
//
//        Consumer<Integer> convertDollar1 = won -> {
//            double rate = 1450;
//            double dollar = won / rate;
//            System.out.printf("환율적용  : $%.2f",dollar);
//        };
//        convertDollar1.accept(30000);
//
//        Function<Integer,Double> convertDollar2 = won -> (double) (won / 1450);


        Predicate<String> isLenZero = str -> str.trim().isEmpty();
        List<String> stringList = Arrays.asList("!@3","#123","");
      
        stringList.stream().filter(str -> isLenZero.test(str)).forEach(System.out::println);
        stringList.stream().filter(isLenZero::test).forEach(System.out::println);
        stringList.stream().filter(isLenZero).forEach(System.out::println);
    }
}
