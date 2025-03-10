package com.ino.section02.list.run;

import java.util.Stack;

public class Application6 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();
        System.out.println(stack.isEmpty());
        stack.push(10);
        stack.peek();
    }
}
