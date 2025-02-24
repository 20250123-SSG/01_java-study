package com.podoseee.practice5.dto;

public class Employee {

    private int id;
    private String name;
    private String department;
    private String position;
    private int age;
    private String gender;
    private int salary;
    private double bonusPoint;
    private String phone;
    private String address;

    public Employee() {}

    public Employee(int id, String name, int age, String gender, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public Employee(int id, String name, String department, String position, int age, String gender, int salary, double bonusPoint,  String phone, String address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.bonusPoint = bonusPoint;
        this.phone = phone;
        this.address = address;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(double bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAnnualSalary() {
        return (int) ((salary + (salary * bonusPoint)) * 12);
    }

    public String getInformation() {
        return id + ", " + name + ", " + department + ", " + position + ", " + age + ", " + gender +
                ", " + salary + ", " + bonusPoint + ", " + phone + ", " + address;
    }

}
