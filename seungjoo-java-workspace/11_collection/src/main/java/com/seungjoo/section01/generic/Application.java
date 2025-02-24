package com.seungjoo.section01.generic;

public class Application {
    public static void main(String[] args) {



        //String 보관
//        Container<String> strContainer = new Container<>();
//        strContainer.setItem("안녕하세요.");
//        System.out.println(strContainer);


        //int 보관
//        Container<int> intContainer = new Container<>();
        Container<Integer> intContainer = new Container<>();
        intContainer.setItem(10); //10은 int이지만 오토박싱되서 전달이 됨.(int->Integer) 인스턴스 타입으로 전달이 됨
        System.out.println(intContainer);


        //String[] 보관
        Container<String[]> strContainer = new Container<>();
        strContainer.setItem(new String[]{"안녕", "잘가"});
        System.out.println(strContainer);


        Container whatContainer = new Container();
        whatContainer.setItem("안녕");
        System.out.println(whatContainer);
        whatContainer.setItem(10);
        System.out.println(whatContainer);
    }

}
