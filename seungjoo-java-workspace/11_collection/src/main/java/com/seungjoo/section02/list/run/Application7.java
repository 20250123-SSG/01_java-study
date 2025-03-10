package com.seungjoo.section02.list.run;

import java.util.LinkedList;
import java.util.Queue;

public class Application7 {
    public static void main(String[] args) {

        Queue<String> q = new LinkedList<String>();
        q.offer("first");
        q.offer("second");
        q.offer("third");
        q.offer("fourth");
        q.offer("fifth");
        System.out.println(q);
        q.peek();
        q.poll();
        System.out.println(q);
    }
}
