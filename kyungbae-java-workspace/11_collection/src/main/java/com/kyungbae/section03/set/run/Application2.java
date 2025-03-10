package com.kyungbae.section03.set.run;

import com.kyungbae.section03.set.dto.Student;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {

        Set<Student> set = new HashSet<>();

        System.out.println("초기 set= " + set);

        set.add(new Student("김첨지", 26, 40));
        set.add(new Student("공유", 43, 100));
        set.add(new Student("홍길동", 24, 20));
        set.add(new Student("공유", 43, 100));
        // add 메소드 내에서 기존에 존재하는 요소들과 인자로 전달된 요소가지고 동등객체인지 판별
        // => hashCode() 의 결과가 일치하고, equals()의 결과가 true일 경우 동등객체로 판별됨

        System.out.println("set= " + set);

        // contains(Object o) : Set 내에 전달된 요소가 포함되어있을 경우 true 반환
        System.out.println(set.contains(new Student("홍길동", 24, 20)));

        // 순회하는 4가지 방법
        for(Student arr : set){
            System.out.println(arr);
        }
        System.out.println("--------------");

        List<Student> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("--------------");

        Object[] stuArr = set.toArray();
        for(Object a : stuArr){
            System.out.println(a);
        }
        System.out.println("--------------");

        Iterator<Student> iteStu = set.iterator();
        while(iteStu.hasNext()){
            System.out.println(iteStu.next());
        }

    }
}
