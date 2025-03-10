package com.ino.section03.set.dto;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int score;

    public Student(){}

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Student o) {
        // 나이순 오름차순 ( 앞의 학생 나이가 더 클 경우 순서 변경 필 )
        return this.age > o.age ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

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
}
