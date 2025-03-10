package com.john.section01.stream;

import com.john.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
    #스트림(Stream)
    - 배열이나 컬렉션의 데이터 관리를 함수형으로 간단하게 처리할 수 있는 기술
    - 스트림 내부 반복자를 통해 순차적으로 요소에 접근

    # 특징
    - 원본데이터를 변경하지 않음(읽기만 수행)
    - 한번 사용한 이후 닫히면 재사용 불가(일회성)
    - 내부 요소들을 가지고 반복 처리(for형식의 반복)

    # 활용
    - 스트림 생성: 관리할 배열 및 컬렉션을 스트림으로 생성
    - 스트림 가공: 생성된 스트림으로 원하는 결과를 만들기 위한 가공처리
    - 스트림 결과: 작업이 완료된 스트림으로 최종결과 만들기

 */
public class Application1 {
    public static void main(String[] args) {
        /*
            스트림 생성방법
            1. 값사용   => Stream.of(val1, val2, ...): Stream<값의 타입>
            2. 배열사용  => Arrays.stream([array])   : Stream<배열 내 요소 타입>
            3. 컬렉션사용 => 컬레션.stream()           : Stream<컬렉션 내의 요소 타입>
         */

        // 값사용
        Stream<String> fruites = Stream.of("사과", "키위", "바나나", "배", "복숭아");

        // 배열 사용
        Integer[] arr = {10,9,4,29,20,18,1,7};
        Stream<Integer> nums = Arrays.stream(arr); // int[] 이였다면 IntStream으로 반환됨

        List<Snack> list = List.of(new Snack("포카칩", "SKT", 2000)
                                 , new Snack("초코비","삼양",3000)
                                 , new Snack("자갈치", "부산", 6500)
                                 , new Snack("맛동산", "농심", 700));

        Stream<Snack> snacks  = list.stream();

        // * count() : 스트림 내의 요소 개수 반환
        System.out.println("snack 개수: " + snacks.count());

        // * distinct() : 스트림 내의 중복요소 없앤 후 Stream반환
        System.out.println("num 중복제거 후 개수: " + nums.distinct().count());

        // * sorted() : 스트림 내의 요소들을 오름차순 정렬시킨 Stream 반환
        // *forEach(Consumer) : Stream내의 요소들에 순차접근하면서 전달된 Consumer 객체의 accept 메소드 실행
        //                      즉, 요소를 순회하면서 실행시키고자 할 내용의 람다식을 전달하면됨
        fruites.sorted().forEach(System.out::println);
    }

}
