package com.john.section02.list.run;

import java.util.Stack;

/*
    Stack
    1. Vector 클래스를 상속받아 구현
    2. 선형 메모리 공간에 데이터를 저장, LIFO(Last Input First Out)
 */
public class Application6 {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<Integer>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);

        System.out.println(integerStack);

        System.out.println("stack size: " + integerStack.size());

        System.out.println("stack search: " + integerStack.search(5));

        System.out.println("stack peek: " + integerStack.peek());

        System.out.println("stack pop: " + integerStack.pop());
        System.out.println("stack pop: " + integerStack.pop());
        System.out.println("stack pop: " + integerStack.pop());
        System.out.println("stack pop: " + integerStack.pop());
    }
}
