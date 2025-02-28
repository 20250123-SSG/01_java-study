package com.younggalee.section03.assist_stream.object;

import java.io.Serializable;

public class PersonDto implements Serializable { // 직렬화 : 바이트형태로 데이터를 변환해줌 >> write가능해짐 NotSerializableException
    // 객체 속성을 표시해주기 위한 인터페이스 (이 클래스는 시리얼라이저블이 가능한 객체이다를 표현하기 위한 목적 뿐 / 톺아보면 내용없음)
    private String name;
    private int age;
    private double height;
    private char grade;

    public PersonDto(){}

    public PersonDto(String name, int age, double height, char grade) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.grade = grade;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", grade=" + grade +
                '}';
    }
}
