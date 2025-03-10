package com.ino.section02.lambda.run;

import com.ino.section02.lambda.my_functional_interface.FuncInterface1;
import com.ino.section02.lambda.my_functional_interface.FuncInterface2;
import com.ino.section02.lambda.my_functional_interface.FuncInterface3;

public class Application {
    public static void main(String[] args) {
        FuncInterface1 func1 = () -> System.out.println("Hello World");
        func1.print();

        FuncInterface2 func2 = () -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            return sum;
        };
        System.out.println(func2.total());

        FuncInterface3 func3 = (str -> System.out.println(str));
        FuncInterface3 func3_2 = System.out::println;

        func3.print("ino");
        func3_2.print("hello :)");
    }
}
