package com.inyong.section01.generic;

public class Application {
    public static void main(String[] args) {
        // String
        Container<String> strContainer = new Container<>();
        strContainer.setItem("String type");
        System.out.println(strContainer);

//        Container<int> intContainer = new Container<>();

        Container<Integer> intContainer = new Container<>();
        intContainer.setItem(1);
        System.out.println(intContainer);


        Container<String[]> strsContainer = new Container<>();
        strsContainer.setItem(new String[]{"13", "23"});
        System.out.println(strsContainer);

        // 미지정시 불안정해서 오류 가능성 있음
        Container whatContainer = new Container();
        whatContainer.setItem("안녕");
        System.out.println(whatContainer);
        whatContainer.setItem("10");
        System.out.println(whatContainer);
    }
}
