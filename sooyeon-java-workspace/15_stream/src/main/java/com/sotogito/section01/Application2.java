package com.sotogito.section01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        /**
         * 기본 타입 스트림
         * - IntStream
         * - LongStream
         * ...
         */

        /// 기본타입스트림.range(시작,종료) : 시작값~종료값이전 까지 1씩증가하는 스트림생성
        ///  기본타입스트림.rangeClosed(시작, 종료) : 시작~ 종료값 까지

        IntStream intStream = IntStream.range(5, 10);
        intStream.forEach(num -> System.out.print(num + " ")); //5,6,7,8,8.9

        LongStream longStream = LongStream.rangeClosed(5, 10);
        longStream.forEach(num -> System.out.print(num + " "));//5,6,7,8,9,10


        ///  문자열.chars() : 문자열의 각 문자들의 아스키 정수들이 담긴 IntStream을 반환
        IntStream chrStream = "hello".chars();
        chrStream.forEach(System.out::println);


        /// Random객체.doubles(개수) : 난수를 해당 개수만큼 발생시켜 D.S 반환
        DoubleStream randomStream = new Random().doubles(5);
        /// 기본타입.boxed() : 기본타입스트림을 박싱해서 wrapper타입의 stream반환
        Stream<Double> randomStreamD = new Random().doubles(5).boxed();
        randomStreamD.forEach(System.out::println);
        randomStream.forEach(System.out::println);

        /// Pattern.compile(구분자).splitAsStream(문자열) : 문자열을 구분자 기준으로 분리하여 스트림으로 반환
        Stream<String> splitStream = Pattern.compile("hefewf ,we,fw,ef,wef,e").splitAsStream(",");
        List<String> trimList = new ArrayList<>();
        splitStream.forEach(str -> trimList.add(str.trim()));


        try (BufferedReader in = new BufferedReader(new FileReader("C:\\dev\\env\\jdk-17.0.14_7\\NOTICE"))) {
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            /// BufferedReader객체.lines() : 읽어들인 파일의 각 라이들을 요소로 저정하는 Stream

            Stream<String> lineStream = in.lines();
            lineStream.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        /// Stream.concat(스1,스2) : 두개의 스트림을 합쳐서 하나의 스트림으로 반환
        Stream<Integer> concatStream = Stream.concat(Stream.of(1, 2, 3), intStream.boxed()); //Intstream != Stream<Integer> // Stream<Integer> == IntStream.boxed()
        //일회성이라 위에서 한번 사용된 스트림은 재사용 불가 -> concat도 마찬가지

    }



}
