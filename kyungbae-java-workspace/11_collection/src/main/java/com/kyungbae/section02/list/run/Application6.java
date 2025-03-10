package com.kyungbae.section02.list.run;

import java.util.Stack;

public class Application6 {
    public static void main(String[] args) {
        // java.util.Stack

        Stack<Integer> intStack = new Stack<>();

        // push(E item) : 인자로 전달된 요소를 추가
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5);

        System.out.println(intStack);

        // size()
        System.out.println("size()= " + intStack.size());

        // search(Object o) : 인자로 전달된 요소를 찾아 해당 순번을 반환
        System.out.println(intStack.search(5)); // 1

        // peek() : 해당 스택의 가장 마지막에 있는 (상단에 있는) 요소 반환
        System.out.println("peek()= " + intStack.peek());
        System.out.println(intStack);

        // pop()
        System.out.println("pop()= " + intStack.pop());
        System.out.println("pop()= " + intStack.pop());
        System.out.println("pop()= " + intStack.pop());
        System.out.println("pop()= " + intStack.pop());
        System.out.println("pop()= " + intStack.pop());
        System.out.println(intStack);

//        System.out.println("pop()= " + intStack.pop()); // EmptyStackException 발생

        /* StackOverflowError 발생
        while(true){
            main(null);
        }
         */

    }
}
