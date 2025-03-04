package com.podoseee.section03.provide_functional_interface;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Practice {
    public static void main(String[] args) {
/*
    실습1.
    전달된 LocalTime 객체를 가지고 HH:mm:ss을 출력하는 람다식을 작성해보시오.
    현재시각을 전달하여 람다식을 실행시켜보시오.
 */
        Consumer<LocalTime> timeFormatter
                = time -> System.out.println((DateTimeFormatter.ofPattern("HH:mm:ss".format(String.valueOf(time)))));
        timeFormatter.accept(LocalTime.now());
        System.out.println();
/*
    실습2.
    로또번호를 생성해서 반환하는 람다식을 작성해보시오.
    단, 반환 타입은 Set<Integer> 으로 할 것
    람다식을 실행하여 발생된 로또번호를 확인하시오.
 */

        Supplier<Set<Integer>> lotto = () -> {
            Set<Integer> lottoNumbers = new TreeSet<>();
            Random random = new Random();

            while (lottoNumbers.size() < 6){
                lottoNumbers.add(random.nextInt(45) + 1); // 1~45 사이 랜덤 숫자 추가
            }
            return lottoNumbers;
        };

        Set<Integer> lottoNumbers = lotto.get();
        System.out.println("생성된 로또 번호: " + lottoNumbers);

        //선생님 풀이
        /*

         */

/*
    실습3.
    원화를 전달하면 환율 계산을 통해 얻어진 달러를 출력하는 람다식을 작성해보시오.
    현재 1달러는 1450원이라고 가정할 것.
    특정 원화값을 전달하여 람다식을 실행시켜 결과를 확인해보시오.
 */

        Consumer<Integer> convertDollar1 = won -> {
            double rate = 1450;
            double dollar = won / rate;
            System.out.printf("환율적용: $%.2f\n", dollar);
        };
        convertDollar1.accept(3000);

/*
    실습4.
    위의 실습3. 에서 달러를 출력하는게 아니라 반환하도록 람다식을 작성해보시오.
    동일하게 람다식을 실행시켜 결과를 확인하시오.
 */

        Function<Integer, Double> convertDollar2 = won -> {
            double rate = 1450;
            return won / rate;
        };
        double dollar = convertDollar2.apply(3000);
        System.out.printf("환율적용: $%.2f\n", dollar);

        System.out.println();

/*
    실습5.
    문자열 앞과 뒤 공백을 제외한 길이가 0인지를 체크하는 람다식을 작성해보시오.
    문자열리스트 {"abc", "", "  대한민국", "   "} 를 가지고 람다식을 실행시켜 확인하시오.
 */

        Predicate<String> isLenZero = str -> str.trim().length() == 0;

        List<String> strList = Arrays.asList("abc", "", " 대한민국", "  ");
        for(String str : strList){
            System.out.println("[" + str + "]의 길이는 0입니까: " + isLenZero.test(str));

        }

        /* 뒤에 코드 더있나???? */
    }
}
