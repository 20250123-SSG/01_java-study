package com.seungjoo.practice1.dto;

public class Dog extends Animal {


    public final String PLACE = "애견카페";
    private int weight;

    public Dog(){}

    public Dog(String name, String kinds, int weight) {
        super(name, kinds);
        this.weight = weight;
    }

    public String getPLACE() {
        return PLACE;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

        @Override
        public void speak () {
            System.out.println(super.toString() + "몸무게는 " + weight + "kg 입니다.");
        }
    }
