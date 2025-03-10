package com.kyungbae.section01.stream;

import com.kyungbae.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {

        // ## Stream 생성

        // 1. 값들을 통해 생성 => Stream.of(값1,값2,...) : Stream<값의 타입>
        Stream<String> fruits = Stream.of("사과", "바나나", "배", "복숭아", "파인애플");
//        System.out.println(fruits); // => 레퍼런스 값 나옴


        // 2. 배열을 통해 생성 => Arrays.stream(배열) : Stream<배열내의 요소 타입>
        Integer[] arr = {10,3,5,20,1,3,23}; // int[] 로 만들었다면
        Stream<Integer> nums = Arrays.stream(arr); // IntStream 으로 반환됨


        // 3. 컬랙션을 통해 생성 => 컬렉션.Stream() : Stream<컬렉션내의 요소 타입>
        List<Snack> list = List.of(
                new Snack("먹태깡", "농심", 2000)
                , new Snack("홈런볼", "롯데", 1500)
                , new Snack("수미칩", "롯데", 2500)
                , new Snack("자갈치", "농심", 700)
        );
        Stream<Snack> snacks = list.stream();

        // 메소드
        // count() : 스트림 내의 요소 개수 반환
        System.out.println("Snack 개수: " + snacks.count());

        // distinct() : 스트림 내의 중복요소 없앤 후 Stream 반환
        System.out.println("num 중복제거 후 개수: " + nums.distinct().count());

        // sorted() : 스트림 내의 요소들을 오름차순 정렬시킨 Stream 반환
        // forEach(Consumer) : Stream내의 요소들에 순차접근하면서 전달된 Consumer 객체의 accept 메소드 실행
        fruits.sorted()
                .forEach(System.out::println);



    }
}
