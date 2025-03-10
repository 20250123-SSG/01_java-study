package com.inyong.section02.list.run;

import java.util.Stack;

public class Application6 {
    public static void main(String[] args) {
        /*
        ## java.util.Stack
        Vector 클래스를 상속바당 구현
        선형 메모리 공간에 데이터를 저장하며
        후입 선출 방식의 자료 구조

         */

        Stack<Integer> intStack = new Stack<>();

        // * push(E item) : 인자로 전달된 요소를 추가
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5);
        intStack.push(6);

        System.out.println(intStack);

        //* size()
        System.out.println("size : " + intStack.size());

        //* search(Object o) : 인자로 전달된 요소를 찾아 해당 순번을 반환
        System.out.println(intStack.search(5));

        // * peek() : 해당 스택의 가장 마지막에 있는 요소 반환

        // * pop() : 해당 스택에 가장 마지막에 있는 요소 반환 후 제거

    }
}
