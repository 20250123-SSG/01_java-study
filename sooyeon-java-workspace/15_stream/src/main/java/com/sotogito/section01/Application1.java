package com.sotogito.section01;

import com.sotogito.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application1 {
    /**
     * ## util.stream.Stream
     * 1. 배열이나 컬렉션을 데이터 관리를 함수형으로 간한하게 처리할 수 있는 기술, 스트림 내부에 반복자를 통해 순차적으로 요소 접근 가능
     * <p>
     * - 원본데이터를 변경하지 않음, 단순히 읽기만
     * - 일회성
     * - 순회하는 목적이 강함 (컬렉션처럼 특정 인덱스 값의 요소를 가져오지 못함)
     * - 내부 요소들을 가지고 반복 처리
     * <p>
     * 1. 스트림 생성 : 관리할 배열 및 컬렉션을 스트림으로 생성
     * 2. 스트림 가공 : 생성된 스트림으로 원하는 결과를 만들기 위한 필터링, 매핑
     * 3. 스트림 결과 : 작업이 완료된 스트림으로 최종 결과 만들기
     */

    public static void main(String[] args) {
        /**
         * ## 스트림 생성
         * 1. 요소 => Stream.of(값1, 값2...) : Stream<값의 타입>
         * 2. 배열 => Arrays.stream(배열) : Stream<배열내의 요소 타입>
         * 3. 컬렉션 => 컬렉션.stream() : Stream<컬렉션 내의 요소 타입>
         */

        Stream<String> fruits = Stream.of("apple", "banana", "orange");
        fruits.forEach(System.out::println);

        Integer[] array = {1, 2, 3, 4, 5};
        Stream<Integer> numStream = Arrays.stream(array);


        List<Snack> snacks = List.of(
                new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700));

        Stream<Snack> snackStream = snacks.stream();


        //distinct() : 중복 제거
        System.out.println(numStream.distinct().count());

        //sorted()  스트림 내의 요소들을 오름차순으로 정렬
        // forEach(Consumer) : Stream내의 요소들에 순차적 접근하여 전달된 컨슈머 accept메서드실행, 요소를 순회하며 실행하고자하는 람다식을 전당
        fruits.sorted().forEach(System.out::println);
    }
}
