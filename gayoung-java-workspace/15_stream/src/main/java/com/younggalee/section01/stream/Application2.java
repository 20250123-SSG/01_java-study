package com.younggalee.section01.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.temporal.ValueRange;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        // 기본타입스트림 : IntStream, LongStream, ...
        // 기본타입스트림.range(시작값, 종료값) : 시작값부터 1씩 증가하는 숫자로 종료값 이전까지의 범위의 기본타입스트림 생성
        //기본타입스트림.rangeClosed(시작값, 종료값) : 시작값부터 1씩 증가하는 숫자로 종료값까지의 범위의 기본타입스트림 생성
        IntStream intStream = IntStream.range(5,10);
        intStream.forEach(value -> System.out.print(value + " "));
        System.out.println();

        LongStream longStream = LongStream.rangeClosed(5, 10);
        longStream.forEach(value -> System.out.print(value + " "));
        System.out.println();

        // 문자열.chars() : 문자열의 각 문자들에 해당하는 정수값들이 담긴 IntStream 반환
        IntStream helloStream = "hello".chars();
        helloStream.forEach(value -> System.out.print(value + " "));
        System.out.println();

        // Random객체.doubles(개수) : 난수를 해당개수만큼 발생시켜서 DoubleStream에 반환
        //DoubleStream DoubleStream = new Random().doubles(5);

        // 기본타입스트림객체.boxed() : 기본타입스트림을 박싱해서 Wrapper 타입의 Stream 반환
        Stream<Double> doubleStream = new Random().doubles(5).boxed();
        doubleStream.forEach(value -> System.out.print(value + " "));
        System.out.println();

        // Pattern.compile(구분자).splitAsStream(문자열) : 문자열을 구분자 기준으로 split해서 Stream에 담아 반환
        Stream<String> splitStream = Pattern.compile(",").splitAsStream("html,css,javascript");
        splitStream.forEach(System.out::println);

        System.out.println("==================");
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\storage\\NOTICE"))){
            /*
            String line = null;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
            */


            // BufferedReader객체.lines() : 읽어들인 파일의 각 라인들을 요소로 저장하는 Stream 반환
            Stream<String> lineStream = in.lines();
            lineStream.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=================");

        // Stream.concat(스트림객체1, 스트림객체2): 두개의 스트림객체를 합쳐 새로운 Stream으로 반환
        Stream<Integer> concatStream = Stream.concat(intStream.boxed(), helloStream.boxed()); // 기본타입Stream을 Stream<타입>으로 바꿔주는 메소드 .boxed()
        concatStream.forEach(System.out::println);
        // IllegalStateException : stream has already been operated upon or closed
        // 일전에 해당 Stream을 foreach돌리면서 순회 진행함. 이미 사용했기에 발생하는 에러. Stream은 일회성이다.


    }
}
