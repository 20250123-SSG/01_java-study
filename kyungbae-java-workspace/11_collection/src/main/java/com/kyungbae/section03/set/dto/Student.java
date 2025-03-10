package com.kyungbae.section03.set.dto;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private String name;
    private int age;
    private int score;

    public Student() {}

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return age == student.age && score == student.score && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score);
    }


    @Override
    public int compareTo(Student o) {
        // 나이순 오름차순 정렬 (앞의 학생 나이가 더 크면 순서를 변경해야됨 => 양수 반환되도록)
        return this.age > o.age ? 1 : -1;
    }
}
