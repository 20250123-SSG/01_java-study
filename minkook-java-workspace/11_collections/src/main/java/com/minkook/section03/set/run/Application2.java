package com.minkook.section03.set.run;

import com.minkook.section03.set.dto.Student;

import java.util.*;

public class Application2 {
    public static void main(String [] args){
        Set<Student> set = new HashSet<>();

        System.out.println("초기set: " + set);
        set.add(new Student("김말똥",26,40));
        set.add(new Student("공유",43,100));
        set.add(new Student("홍길동",24,20));
        set.add(new Student("공유",43,100));
        System.out.println("추가후 set: " + set); //순서 유지 안됨
        //add 메소드 내에서 기존에 존재하는 요소들과 인자로 전달된 요소가지고 동등객체인지 판별
        //= > hashcode()의 값이 일치하고 equals의 결과가 true일 경우 동등객체로 판별됨
        
        //Student 클래스에서 hashcode,equals 오버라이딩 전 : Object클래스의 hashcode,equals가 수행됨 => 주소값 가지고 비교

        System.out.println(set.contains(new Student("홍길동",24,20)));

        //순회 방법 4가지
        for(Student s : set){
            System.out.println(s);
        }

        System.out.println("===================");
        Object[] students = set.toArray();

        for(int i = 0; i<students.length; i++){
            System.out.println(students[i]);
        }

        System.out.println("===================");

        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("===================");
        List<Student> list = new ArrayList<>(set);
        for(int i = 0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
