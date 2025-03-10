package com.podoseee.section03.set.run;

import com.podoseee.section03.set.dto.Student;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {

        Set<Student> set = new HashSet<>();

        System.out.println("초기 set : " + set);

        set.add(new Student("김수연", 26, 40));
        set.add(new Student("공유", 43, 100));
        set.add(new Student("이서연", 23, 90));
        set.add(new Student("공유", 43, 100));
        // add 메소드 내에서 기존에 존재하는 요소들과 인자로 전달된 요소가지고 동등객체인지 판별
        // => hashCode()의 결과가 일치하고, equals()의 결과가 true일 경우 동등객체로 판별됨

        // Student 클래스에 hashCode, equals 오버라이딩 전 : Object클래스의 hashCode, equals가 수행됨 => 주소값 가지고 비교
        // Student 클래스에 hashCode, equals 오버라이딩 후 : Student클래스의 hashCode, equals가 수행됨 => 필드값 가지고 비교
        System.out.println("추가후 set: " + set); // 순서유지x

        // * contains(Object o) : Set 내에 전달된 요소가 포함되어있을 경우 true 반환
        System.out.println(set.contains(new Student("이서연", 23, 90)));

        // 순회 방법 4가지 방법
        // 향상된 for문, 배열, list, iterator

        for(Student s : set){
            System.out.println(s);
        }
        System.out.println("---------");

        Object[] stuArr = set.toArray();
        for(int i=0; i<stuArr.length; i++){
            System.out.println(stuArr[i]);
        }
        System.out.println("---------");

        List<Student> list = new ArrayList<>(set);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("---------");

        Iterator<Student> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
