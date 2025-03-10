package com.john.section03.provide_functional_interface;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;

/*
    실습1.
    전달된 LocalTime 객체를 가지고 HH:mm:ss을 출력하는 람다식을 작성해보시오.
    현재시각을 전달하여 람다식을 실행시켜보시오.

    실습2.
    로또번호를 생성해서 반환하는 람다식을 작성해보시오.
    단, 반환 타입은 Set<Integer> 으로 할 것
    람다식을 실행하여 발생된 로또번호를 확인하시오.

    실습3.
    원화를 전달하면 환율 계산을 통해 얻어진 달러를 출력하는 람다식을 작성해보시오.
    현재 1달러는 1450원이라고 가정할 것.
    특정 원화값을 전달하여 람다식을 실행시켜 결과를 확인해보시오.

    실습4.
    위의 실습3. 에서 달러를 출력하는게 아니라 반환하도록 람다식을 작성해보시오.
    동일하게 람다식을 실행시켜 결과를 확인하시오.

    실습5.
    문자열 앞과 뒤 공백을 제외한 길이가 0인지를 체크하는 람다식을 작성해보시오.
    문자열리스트 {"abc", "", "  대한민국", "   "} 를 가지고 람다식을 실행시켜 확인하시오.
 */
public class Practice {
    public static void main(String[] args) {
        /* 내풀이
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        Consumer<LocalDateTime> consumer = localDateTime -> System.out.println("현재시간 = " + dtf.format(localDateTime));
        consumer.accept(LocalDateTime.now());
         */
        Consumer<LocalTime> consumer = time -> System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss").format(time));
        consumer.accept(LocalTime.now());

        /* 내 풀이
        Supplier<Set<Integer>> lottoNum = () -> {
            int count = 0;
            Set<Integer> set = new HashSet<>();
            while (count < 6) {
                int num = (int) (Math.random() * 45) + 1;
                if (!set.contains(num)){
                    set.add(num);
                }
                count++;
            }
            return set;
        };
        System.out.println(lottoNum.get());
         */
        Supplier<Set<Integer>> lottoGenerate = () -> {
            Set<Integer> lottoSet = new TreeSet<>();
            while(lottoSet.size() < 6){
                int num = ((int)(Math.random()*45 + 1));
                lottoSet.add(num);
            }
            return lottoSet;
        };

        /* 내 풀이
        DoubleConsumer doubleConsumer = num -> {
            System.out.printf("달러 환산(1:1450)값은 대락 %.1f 달러입니다.", (num/1450));
        };
        System.out.print("원화 입력: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        doubleConsumer.accept(num);
        */
        Consumer<Integer> convertDollar = won -> {
            double rate = 1450;
            double dollor = (won / rate);
            System.out.printf("환율 적용 시 대락 %.1f 달러입니다. \n", dollor);
        };
        convertDollar.accept(20000);

        Function<Integer, Double> function = won -> {
            double rate = 1450;
            return (won / rate);
        };
        double result = function.apply(20000);
        System.out.printf("환율 적용 시 대락 %.1f 달러입니다. \n", result);

        Predicate<String> isLenZero = str -> str.trim().length() == 0;
        List<String> strings = Arrays.asList("abc","지친내모습", "13", " ", "");
        for (String str : strings) {
            System.out.println(isLenZero.test(str));
        }
    }
}
