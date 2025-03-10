package com.seungjoo.section03.set.run;

import com.seungjoo.section03.set.dto.Student;

import java.sql.SQLOutput;
import java.util.*;

public class Application2 {
    public static void main(String[] args) {

        Set<Student> set = new HashSet<>();

        System.out.println("초기 set :" + set);

        set.add(new Student("김말똥", 26, 40));
        set.add(new Student("공유", 43, 100));
        set.add(new Student("홍길동", 24, 20));
        set.add(new Student("공유", 43, 100));
        // add 메서드 내에서 기존에 존재하는 요소들과 인자로 전달된 요소가지고 동등객체인지 판별



        System.out.println(set);

        Object[] stuArr = set.toArray();
        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i]);

        }
        System.out.println("========");

        List<Student> list = new ArrayList<>();
        Iterator<Student> iterator = set.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student);
        }


    }
}
