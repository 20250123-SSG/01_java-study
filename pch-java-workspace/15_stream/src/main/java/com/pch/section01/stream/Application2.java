package com.pch.section01.stream;

import java.util.*;
import java.util.stream.*;

public class Application2 {
    public static void main(String[] args) {
        // * 기본타입스트림 : IntStream (Stream<Integer>), LongStream ...

        // * 기본타입스트림.range(시작값, 종료값) : 시작값부터 1씩 증가하는 숫자로 종료값 이전까지의 범위의 기본타입스트림 생성
        // * 기본타입스트림.rangeClosed(시작값, 종료값) : 시작값부터 1씩 증가하는 숫자로 종료값까지의 범위의 기본타입스트림 생성
        IntStream intStream = IntStream.range(5, 10);
        intStream.forEach(value -> System.out.print(value + " "));
        System.out.println();

        LongStream longStream = LongStream.rangeClosed(5, 10);
        longStream.forEach(v -> System.out.print(v+" "));
        System.out.println();

        // * 문자열.chars() : 문자열의 각 문자들에 해당하는 정수값들이 담긴 IntStream 반환
        IntStream helloStream = "hello".chars();
        helloStream.forEach(v -> System.out.print(v+" "));
        System.out.println();

        // * Random객체.doubles(개수) : 난수를 해당 개수만큼 발생시켜 DoubleStream 반환
        // * 기본타입스트림객체.boxed() : 기본타입스트림을 박싱해서 Wrapper 타입의 Stream 반환
        Stream<Double> doubleStream = new Random().doubles(5).boxed();
        doubleStream.forEach(v -> System.out.print(v+" "));
        System.out.println();


    }
}
