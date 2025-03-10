package com.younggalee.section01.stream;

import com.younggalee.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    /*
            ## java.util.stream.Stream ##
            1. 자바 8 부터 사용 가능
            2. 배열이나 컬렉션의 데이터 관리를 함수형으로 간단하게 처리할 수 있는 기술
               스트림내부의 반복자를 통해서 순차적으로 요소에 접근됨
            3. 특징
               1) 가공시 원본 데이터를 변경하지 않음 (only 읽기 수행)
               2) 한번 사용후 닫히면 더이상 재사용이 불가능함 (일회성. 한번만 순회시킬 수 있음. iterator같은 느낌)
               3) 내부 요소들을 가지고 반복 처리함.
            4. 활용
               1) 스트림 생성 : 관리할 배열 및 컬렉션을 스트림으로 생성
               2) 스트림 가공 : 생성된 스트림으로 원하는 형태의 결과를 만들기 위한 가공처리 (필터링, 맵핑 등)
               3) 스트림 결과 : 작업이 완료된 스트림으로 최종 결과 만들기
         */

    public static void main(String[] args) {

        /*
            ## Stream 생성 ##
            1. 값들을 통해 >> Stream.of() : 객체를 만들어낼때 쓰는 메소드 (return Stream<제네릭 값의 타입>)
            2. 배열을 가지고 스트림으로 만들고 싶을때 >> Arrays.stream(배열) : (return Stream<배열내의 요소 타입>)
            3. 컬렉션을 통해 >> 컬랙션.stream() : (return Stream<컬랙션내의 요소 타입>)
         */

        // 과일명이 담겨있는 Stream 제작
        Stream<String> fruits = Stream.of("키위", "사과", "바나나", "배", "복숭아");
        System.out.println(fruits);  // java.util.stream.ReferencePipeline$Head@7a81197d (주소값 반환)

        Integer[] arr = {5, 2, 3, 2, 1};
        Stream<Integer> nums = Arrays.stream(arr);  // int[] 배열이었다면 IntStream으로 배열되었을 것.

        // DTO 객체 담긴 list를 Stream으로 만들어보기
        // 리스트 생성하는 방식 : List.of(수정불가 리스트반환), Array.asList(수정은 가능,but fixed-size)
        List<Snack> list = List.of(
                new Snack("snack1", "농심",2000)
                , new Snack ("snack2","농심", 5000)
                , new Snack ("snack3","농심", 23000)
                , new Snack ("snack4", "농심",7000)
        );
        Stream<Snack> snacks = list.stream();

        // count() : 스트림 내의 요소 개수 반환
        System.out.println("snack개수 : " + snacks.count());

        // distinct() : 스트림 내의 중복요소 없앤 후 Stream 반환
        System.out.println("num 중복제거 후 : " + nums.distinct().count());

        // sorted() : 스트림 내의 요소들을 오름차순 정렬시킨 Stream 반환
        // forEach(Consumer) : Stream내의 요소들에 순차접근하면서 전달된 Consumer 객체의 accept 메소드 실행
        //                     즉, 요소를 순회하면서 실행시키고자 할 내용의 람다식을 전달하면 됨

        fruits.sorted().forEach(System.out::println);
    }
}











