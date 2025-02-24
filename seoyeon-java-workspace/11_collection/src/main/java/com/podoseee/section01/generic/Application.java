package com.podoseee.section01.generic;

public class Application {
    public static void main(String[] args) {

        // String 보관
        Container<String> strContainer = new Container<>();
        strContainer.setItem("안녕하세요");
        System.out.println(strContainer);

        // int 보관
        //Container<int> intContainer = new Container<>();
        Container<Integer> intContainer = new Container<>();
        intContainer.setItem(10); // AutoBoxing (int -> Integer)
        System.out.println(intContainer);

        // String[] 보관
        Container<String[]> strsContainer = new Container<>();
        strsContainer.setItem(new String[]{"안녕", "잘가"});
        System.out.println(strsContainer);


        // 타입 미지정시 => Object로 설정됨
        Container/*<Object>*/ whatContainer = new Container();
        whatContainer.setItem("안녕");
        System.out.println(whatContainer);
        whatContainer.setItem(10);
        System.out.println(whatContainer);

    }
}
