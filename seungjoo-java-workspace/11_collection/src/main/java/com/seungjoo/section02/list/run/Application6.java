package com.seungjoo.section02.list.run;

import java.util.Stack;

public class Application6 {
    public static void main(String[] args) {

        Stack<Integer> intStack = new Stack<>();

        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5);

        System.out.println(intStack);

        //* size()
        System.out.println(intStack.size());

        System.out.println(intStack.search(5));
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());

    }


}
