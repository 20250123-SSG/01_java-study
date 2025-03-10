package com.jjanggu.section03.assist_stream.Object;

import java.io.Serializable;

public class PersonDto implements Serializable { // 직렬화

    private String name;
    private int age;
    private double height;
    private char Grade;

    public PersonDto(){}

    public PersonDto(String name, int age, double height, char grade) {
        this.name = name;
        this.age = age;
        this.height = height;
        Grade = grade;
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
        return Grade;
    }

    public void setGrade(char grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", Grade=" + Grade +
                '}';
    }
}
