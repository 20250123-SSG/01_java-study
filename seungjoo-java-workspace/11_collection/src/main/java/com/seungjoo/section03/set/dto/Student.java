package com.seungjoo.section03.set.dto;

public class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        //나이순으로 오름차순 (앞의 학생 나이가 더 크면 순서를 변경해야됨 =>양수 반환되도록)
        return this.age > o.age ? 1 : -1;
    }

    private String name;
    private int age;
    private int score;

    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
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

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
}
