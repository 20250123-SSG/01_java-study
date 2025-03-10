package com.john.section01.stream;

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
        // 기본 타입 스트림: IntStream, LongStream,...
        // 기본 타입 스트림.range(시작값, 종료값): 시작값부터 1씩 증가하는 숫자로 종료값 이전까지의 범위의 스트림 생성(start, end - 1)
        // 기본 타입 스트림.rangeClosed(시작값, 종료값): 시작값부터 1씩 증가하는 숫자로 종료값까지의 범위의 스트림 생성(start, end)
        IntStream intStream = IntStream.range(5, 10); // 종료값 미포함
        intStream.forEach(value -> System.out.print(value + " "));
        System.out.println();


        LongStream longStream = LongStream.range(5, 10); // 종료값 포함
        longStream.forEach(value -> System.out.print(value + " "));
        System.out.println();

        // 문자열.chars(): 문자열의 각 문자들에 해당하는 정수값들이 담긴 IntStream반환
        IntStream helloStream = "hello".chars();
        helloStream.forEach(value -> System.out.print(value + " "));
        System.out.println();

        // Random객체.doubles(개수): 난수를 해당 개수만큼 발생시켜 DoubleStream반환
        // DoubleStream doubleStream = new Random().doubles(5);

        // 기본 타입스트립 객체.boxed(): 기본타입스트림을 박싱해서 Wrapper타입의 Stream반환
        Stream<Double> doubleStream = new Random().doubles(5).boxed();
        doubleStream.forEach(value -> System.out.print(value + " "));
        System.out.println();

        // Pattern.compile(구분자).splitAsStream(문자열) : 문자열을 구분자 기준으로 split 해서 Stream에 담아 반환
        Stream<String> splitStream = Pattern.compile(",").splitAsStream("html,css,javascript");
        splitStream.forEach(System.out::println);

        System.out.println("===========================");
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\dev\\java\\jdk-17.0.14\\NOTICE"))){
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // BufferedReader객체.lines(): 읽어들인 파일의 각 라인들을 요소로 저장하는 Stream반환
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\dev\\java\\jdk-17.0.14\\NOTICE"))){
            Stream<String> lineStream = br.lines();
            lineStream.forEach(System.out::println);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("===========================");
        
        // Stream.concat(스트림 객체1, 스트림 객체2): 두 개의 Stream객체를 하나로 합쳐 새로운 Stream으로 반환
        // 스트림은 1회성으로 위에서 이미 사용했기 때문에 에러발생
        Stream<Integer> concatStream = Stream.concat(intStream.boxed(), helloStream.boxed());
        concatStream.forEach(System.out::println);
        
    }
}
