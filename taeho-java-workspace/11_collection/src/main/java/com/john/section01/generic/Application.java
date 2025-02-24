package com.john.section01.generic;

public class Application {
    public static void main(String[] args) {
        Container<String> stringContainer = new Container<String>();
        stringContainer.setItem("String");
        System.out.println(stringContainer);

        Container<Integer> integerContainer = new Container<Integer>();
        // AutoBoxing(int => Integer)
        integerContainer.setItem(1);
        System.out.println(integerContainer);

        Container<String[]> stringArrayContainer = new Container<String[]>();
        stringArrayContainer.setItem(new String[] { "String", "Integer" });
        System.out.println(stringArrayContainer);

        // 타입 미지정 => Object로 설정
        Container whatContainer = new Container();
//        whatContainer.setItem(new String[] { "String", "Integer" });
//        whatContainer.setItem(1232);
        System.out.println(whatContainer);

    }
}
