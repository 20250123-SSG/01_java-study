package com.younggalee.section03;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class Practice {
    public static void main(String[] args)
    {
        /*
            실습1.
            전달된 LocalTime 객체를 가지고 HH:mm:ss을 출력하는 람다식을 작성해보시오.
            현재시각을 전달하여 람다식을 실행시켜보시오.
         */
        // 가져와서  실행만 키시려면 consumer
        Consumer<LocalTime> consumer = time -> {
            System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss").format(time));
//            String timeOutput = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//            System.out.println(timeOutput);
        };
        consumer.accept(LocalTime.now());


        /*
            실습2.
            로또번호를 생성해서 반환하는 람다식을 작성해보시오.
            단, 반환 타입은 Set<Integer> 으로 할 것
            람다식을 실행하여 발생된 로또번호를 확인하시오.
         */

        Supplier<Set<Integer>>  supplier = () -> {
            Set<Integer> lotto = new HashSet<>();
            for(int i=0; i<6; i++){ // 동일한 랜덤값이 나오면 Set에서 중복제거되므로 while 사용해서 추가작성
                lotto.add((int)(Math.random()*45 + 1));
            }
            return lotto;
        };
        System.out.println(supplier.get());

        /*
            실습3.
            원화를 전달하면 환율 계산을 통해 얻어진 달러를 출력하는 람다식을 작성해보시오.
            현재 1달러는 1450원이라고 가정할 것.
            특정 원화값을 전달하여 람다식을 실행시켜 결과를 확인해보시오.
         */
        // 출력만을 하기 때문에 consumer가 적합
        Consumer<Integer> convertDollar1 = won -> {
          double rate = 1450;
          double dollar = won / rate;  // 입력이 Integer니까 사용해도 됨...
            System.out.printf("환율적용: $%.2f\n", dollar);
        };
        convertDollar1.accept(3000);

        /*
            실습4.
            위의 실습3. 에서 달러를 출력하는게 아니라 반환하도록 람다식을 작성해보시오.
            동일하게 람다식을 실행시켜 결과를 확인하시오.
         */

        // input O, output O
        Function<Integer, Double> convertDollar2 = won -> {
            double rate = 1450;
            return won / rate;
        };
        double dollar = convertDollar2.apply(3000);
        System.out.printf("달러로 출력하면 약 $%.2f\n달러 입니다.", dollar);


        /*
            실습5.
            문자열 앞과 뒤 공백을 제외한 길이가 0인지를 체크하는 람다식을 작성해보시오.
            문자열리스트 {"abc", "", "  대한민국", "   "} 를 가지고 람다식을 실행시켜 확인하시오.
         */
        // 체크할때는 Predicate
        Predicate<String> isLenZero = str -> str.trim().length() == 0 ? true : false;
        List<String> strList = Arrays.asList("abc", "", "  대한민국", "   ");
        for (String str : strList){
            System.out.println(isLenZero.test(str));
        }


    }

}
