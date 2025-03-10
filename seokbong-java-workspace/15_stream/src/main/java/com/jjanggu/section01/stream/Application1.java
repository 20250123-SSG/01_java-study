package com.jjanggu.section01.stream;

import com.jjanggu.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    /*
       ## java.util.stream.Stream ##
       1. 자바 8부터 사용 가능
       2. 배열이나 컬렉션의 데이터 관리를 함수형으로 간단하게 처리할 수 있는 기술
          스트림 내부 반복자를 통해 순차적으로 요소에 접근됨
       3. 특징
          1) 원본 데이터를 변경하지 않음 (단지 읽기만 수행)
          2) 한번 사용후 닫히면 더이상 재사용이 불가능함 (일회성)
          3) 내부 요소들을 가지고 반복 처리함
       4. 활용
          1) 스트림 생성 : 관리할 배열 및 컬렉션을 스트림으로 생성
          2) 스트림 가공 : 생성된 스트림으로 원하는 결과를 만들기 위한 가공처리(필터링, 매핑 등)
          3) 스트림 결과 : 작업이 완료된 스트림으로 최종 결과 만들기
    */
    public static void main(String[] args) {

        /*
            ## Stream 생성 ##
            1. 값들을 통해   => Stream.of(값1, 값2, ..) : Stream<값의 타입>
            2. 배열을 통해   => Arrays.stream(배열) : Stream<배열내의 요소 타입>
            3. 컬렉션을 통해 => 컬렉션.stream() : Stream<컬렉션내의 요소 타입>
         */

        Stream<String> fruits = Stream.of("키위", "사과", "바나나", "배", "복숭아");

        Integer[] arr = {10, 9, 2, 1, 5, 34, 23, 9};
        Stream<Integer> nums = Arrays.stream(arr); // int[] 이였다면 IntStream 으로 반환됨

        // List.of(Snack, Snack, ..) => unmodifiable , Arrays.asList(Snack, Snack, ..) => fixed-size
        List<Snack> list = List.of(new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700));
        Stream<Snack> snacks = list.stream();

        // * count() : 스트림 내의 요소 개수 반환
        System.out.println("snack 개수: " + snacks.count());

        // * distinct() : 스트림 내의 중복요소 없앤 후 Stream 반환
        System.out.println("num 중복제거 후 개수: " + nums.distinct().count());

        // * sorted() : 스트림 내의 요소들을 오름차순 정렬시킨 Stream 반환
        // * forEach(Consumer) : Stream내의 요소들에 순차접근하면서 전달된 Consumer 객체의 accept 메소드 실행
        //                       즉, 요소를 순회하면서 실행시키고자 할 내용의 람다식을 전달하면됨
        fruits.sorted()
                .forEach(System.out::println);

    }

}
