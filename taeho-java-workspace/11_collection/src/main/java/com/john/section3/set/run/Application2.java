package com.john.section3.set.run;

import com.john.section3.set.dto.Student;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("켄트벡",26,40));
        students.add(new Student("크로마",50,29));
        students.add(new Student("토레스",32,80));

        // hashCode() 및 equals()둘 다 False (Object의 hashCode와 equals메서드가 실행)
        // => Overriding 필요
        students.add(new Student("크로마",50,29));

        System.out.println(students);

        System.out.println(students.contains(new Student("켄트벡",26,40)));

        for (Student student : students){
            System.out.println(student);
        }

        System.out.println("==============");

        List<Student> list = new ArrayList<>(students);
        for (Student student : list){
            System.out.println(student);
        }

        System.out.println("==============");

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student);
        }

        System.out.println("==============");

        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++){
            System.out.println(objects[i]);
        }
    }
}
