package com.kyungbae.section03.provide_functional_interface;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;

public class Practice {
    public static void main(String[] args) {

        // 실습1
        Consumer<LocalTime> date = localTime -> {
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//            System.out.println(localTime.format(dtf));
            // 선생님 풀이
            System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss").format(localTime));
        };
        date.accept(LocalTime.now());

        // 실습2
        Supplier<Set<Integer>> lotto = () -> {
            Set<Integer> set = new TreeSet<>();
            while (set.size() < 6) {
                set.add((int) (Math.random() * 45 + 1));
//                if (set.size() == 6){
//                    return set;
//                }
            }
            return set;
        };
        System.out.println(lotto.get());

        // 실습3
        Consumer<Integer> cons = won -> System.out.println(won/1450 + "달러");
        cons.accept(54000);
        // 선생님 풀이
        Consumer<Integer> changeDollar = won -> {
            double rate = 1450;
            double dollar = won / rate;
            System.out.printf("%.2f달러\n", dollar);
        };
        changeDollar.accept(54000);

        // 실습4
        IntUnaryOperator iuo = won -> (won / 1450);
        System.out.println(iuo.applyAsInt(54000) + "달러");
        //선생님 풀이
        Function<Integer, Double> changeDollar2 = won -> {
          double rate = 1450;
          return won / rate;
        };
        System.out.printf("%.2f달러\n",changeDollar2.apply(54000));

        // 실습5
        Predicate<String> str = text -> text.trim().isEmpty();
        List<String> list = Arrays.asList("abc", "", "  대한민국", "   ");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println("내용이 있나?: " + str.test(it.next()));
        }
        // 선생님 풀이
        Predicate<String> isLenZero = str2 -> str2.trim().length() == 0;
        for(String s : list){
            System.out.println("[" + s + "]의 길이는 0 입니까: " + isLenZero.test(s));
        }

    }
}
