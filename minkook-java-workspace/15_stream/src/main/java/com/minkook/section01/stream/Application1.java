package com.minkook.section01.stream;

import com.minkook.dto.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String [] args){
        /*
            ## java.util.stream.Stream ##
            1. 자바 8부터 사용 가능
            2. 배열이나 컬렉션의 데이터 관리를 함수형으로 간단하게 처리할 수 잇는 기술
                스트림 내부 반복자를 통해 순차적으로 요소에 접근됨
            3. 특징
                1) 원본 데이터를 변경하지 않음(단지 읽기만 수행)
                2) 한번 사용 후 닫히면 더이상 재사용이 불가능함
                3) 내부 요소들을 가지고 반복 처리함

            4. 활용
                1) 스트림 생성: 관리할 배열 및 컬렉션을 스트림으로 생성
                2) 스트림 가공 : 생성된 스트림으로 원하는 결과를 만들기 위한 가공처리(필터링, 매핑)
                3) 스트림 결과 : 작업이 완료된 스트림으로 최종결과만들기
         */

        Stream<String> fruits = Stream.of("키위","사과","바나나","배","복숭아");

        Integer[] arr = {10,9,2,1,5,34,23,9};
        Stream<Integer> nums = Arrays.stream(arr);

        List<Snack> list = List.of(new Snack("먹태깡","농심",1500),
                                   new Snack("홈런볼","롯데",2000),
                                   new Snack("홈런볼","롯데",2000)
                                  );


        Stream<Snack> snacks = list.stream();

        System.out.println(snacks.count());
        System.out.println(nums.distinct().count());


        fruits.sorted()
                .forEach(System.out :: println);

    }
}
