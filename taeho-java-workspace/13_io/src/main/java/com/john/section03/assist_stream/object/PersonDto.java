package com.john.section03.assist_stream.object;

import java.io.Serializable;

public class PersonDto implements Serializable {
    private String name;
    private int age;
    private double height;
    private char grade;

    public PersonDto() {
    }

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
