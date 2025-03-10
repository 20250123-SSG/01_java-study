package com.minkook.section01.stream;

import java.io.*;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Application2 {
    public static void main(String [] args) {

        IntStream intStream = IntStream.range(5, 10);
        intStream.forEach(value -> System.out.println(value + " "));
        System.out.println();

        LongStream longStream = LongStream.rangeClosed(5, 10); //종료값 포함
        longStream.forEach(value -> System.out.print(value + " "));
        System.out.println();


        DoubleStream doubleStream = new Random().doubles(5);


        Stream<String> splitStream = Pattern.compile(",").splitAsStream("html,css,javascript");
        splitStream.forEach(System.out::println);

        System.out.println("==============================================================================");

        try(BufferedReader in = new BufferedReader(new FileReader("C:\\dev\\env\\jdk-17.0.14_7\\NOTICE"))) {
            /*String line = null;
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }*/
            Stream<String> lineStream = in.lines();
            lineStream.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("==============================================================================");


        //Stream<Integer> concatStream = Stream.concat(intStream.boxed(),helloStream.boxed());
    }
}
