package com.ino.section01.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(5, 10);
        intStream.forEach(System.out::println);

        IntStream intStream1 = IntStream.rangeClosed(5, 10);
        intStream1.forEach(System.out::println);

        IntStream helloChars = "hello".chars();

        helloChars.forEach( c -> System.out.println((char) c));

        DoubleStream dStream = new Random().doubles(10);
        Stream<Double> doubleStream = new Random().doubles(10).boxed();

        Stream<String> stringStream = Pattern.compile("\\.").splitAsStream("2921.213.123");
        stringStream.forEach(System.out::println);

        try(BufferedReader br = new BufferedReader(new FileReader("C:\\dev\\env\\jdk-17.0.14_7\\NOTICE"))) {

            Stream<String> stream = br.lines();
            stream.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream<Integer> concatStream = Stream.concat(helloChars.boxed(), intStream1.boxed());
    }
}
