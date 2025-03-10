package com.pch.section02.objectarray.dto;

public class Employee<T> {
    private T id;
    private T name;
    private T age;
    private T dept;
    private T number;
    private T location;
    private T salary;
    private T incentive;

    public Employee() {
    }

    public Employee(T id, T name, T age, T dept, T number, T location, T salary, T incentive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.number = number;
        this.location = location;
        this.salary = salary;
        this.incentive = incentive;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", dept=" + dept +
                ", number=" + number +
                ", location=" + location +
                ", salary=" + salary +
                ", incentive=" + incentive +
                '}';
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public T getDept() {
        return dept;
    }

    public void setDept(T dept) {
        this.dept = dept;
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    public T getLocation() {
        return location;
    }

    public void setLocation(T location) {
        this.location = location;
    }

    public T getSalary() {
        return salary;
    }

    public void setSalary(T salary) {
        this.salary = salary;
    }

    public T getIncentive() {
        return incentive;
    }

    public void setIncentive(T incentive) {
        this.incentive = incentive;
    }
}
