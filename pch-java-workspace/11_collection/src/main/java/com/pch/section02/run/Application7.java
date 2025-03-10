package com.pch.section02.run;

import java.util.LinkedList;
import java.util.Queue;

public class Application7 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("first");
        queue.offer("second");

        System.out.println(queue);

        
    }
}
