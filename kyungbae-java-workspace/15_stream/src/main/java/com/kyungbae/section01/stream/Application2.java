package com.kyungbae.section01.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {

        // 기본타입스트림 : IntStream, LongStream ...

        // 기본타입스트림.range(시작값, 종료값) : 시작값부터 1씩 증가하는 숫자로 *종료값 이전*까지의 범위의 기본타입스트림 생성
        // 기본타입스트림.rangeClosed(시작값, 종료값) : 시작값부터 1씩 증가하는 숫자로 종료값까지의 범위의 기본타입스트림 생성

        IntStream intStream = IntStream.range(5, 10);
//        intStream.forEach(System.out::print);
        System.out.println();

        LongStream longStream = LongStream.rangeClosed(5,10);
        longStream.forEach(System.out::print);
        System.out.println();

        // 문자열.chars() : 문자열의 각 문자들에 해당하는 정수값들이 담긴 IntStream 반환
        IntStream helloStream = "hello".chars();
//        helloStream.forEach(ch -> System.out.print(ch + " "));
        System.out.println();

        // Random객체.doubles(개수) : 난수를 해당 개수만큼 발생시켜 DoubleStream 반환
        DoubleStream doubleStream1 = new Random().doubles(5);

        // 기본타입스트림객체.boxed() : 기본타입스트립을 박싱해서 Wrapper 타입의 Stream 반환
        Stream<Double> doubleStream2 = new Random().doubles(5).boxed();
        doubleStream2.forEach(a -> System.out.printf("%.3f ", a));
        System.out.println();

        // Pattern.compile(구분자).splitAsStream(문자열) : 문자열을 구분자 기준으로 split 해서 Stream 에 담아 반환
        Stream<String> splitStream = Pattern.compile(", ").splitAsStream("html, css, javascript");
        splitStream.forEach(System.out::println);

        System.out.println("-----------------------------------");

        try(BufferedReader in = new BufferedReader(new FileReader("C:\\dev\\env\\jdk-17.0.14_7\\NOTICE"))) {

            // BufferedReader객체.lines() : 읽어들인 파일의 각 라인들을 요소로 저장하는 Stream 반환
            Stream<String> lineStream = in.lines(); // 파일의 한 줄을 각각 기록한 Stream<String> 으로 반환
            lineStream.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;

        System.out.println("-----------------------------------");

        // Stream.concat(스트림객체1, 스트림객체2) : 2개의 Stream 객체를 합쳐서 새로운 Stream 객체로 생성
//        IntStream concatStream = IntStream.concat(intStream, helloStream);
        Stream<Integer> concatStream = Stream.concat(intStream.boxed(), helloStream.boxed());
        // => sout 으로 이미 사용된 Stream (intStream, helloStream)이라서 재사용 불가로 예외 발생
        // => 다시 만들거나 사용했던 sout 주석처리
        concatStream.forEach(System.out::print);


    }
}
