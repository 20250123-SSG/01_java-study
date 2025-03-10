package com.podoseee.section02.list.run;

import java.util.Stack;

public class Application6 {
    public static void main(String[] args) {

        /*
            ## java.util.Stack ##
            1. Vector 클래스를 상속받아 구현
            2. 선형 메모리 공간에 데이터를 저장하며
               후입선출(LIFO - Last Input First Out) 방식의 자료구조
         */

        Stack<Integer> intStack = new Stack<>();

        // * push (E item) : 인자로 전달된 요소를 추가
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5); // 제일 마지막에 추가 == 제일 상단에 위치

        System.out.println(intStack);

        // * size()
        System.out.println("size() : " + intStack.size());

        // * search(Object o) : 인자로 전달된 요소를 찾아 해당 순번을 반환
        System.out.println(intStack.search(5)); // 1

        // * peek() : 해당 스택의 가장 마지막에 있는(상단에 있는) 요소 반환
        System.out.println( "peek() : " + intStack.peek());
        System.out.println(intStack);
        // * pop()  : 해당 스택의 가장 마지막에 있는(상단에 있는) 요소 반환 후 제거
        System.out.println( "pop() : " + intStack.pop());
        System.out.println( "pop() : " + intStack.pop());
        System.out.println( "pop() : " + intStack.pop());
        System.out.println( "pop() : " + intStack.pop());
        System.out.println( "pop() : " + intStack.pop());
        System.out.println(intStack);

       // System.out.println( "pop() : " + intStack.pop()); // EmptyStackException 발생
        /* StackOverFlowError 발생
        while(true){
            main(null);
        }*/
    }
}
