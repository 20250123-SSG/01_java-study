package com.kyungbae.section05.open_api;

public class OverloadingTest {

    public void test(String a, int b){
        System.out.println("test1");
    }

    public void test(int a, String b){
        System.out.println("test2");
    }

}
