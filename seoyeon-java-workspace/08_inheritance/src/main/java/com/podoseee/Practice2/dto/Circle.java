package com.podoseee.Practice2.dto;

import static java.lang.Math.PI;

public class Circle extends Point{
    private int radius;

    public Circle(){}

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public void draw(){
        System.out.println("(x, y) :"+ "(" + getX() + ", " + getY() + ")");
        System.out.println("면적 : " + PI*getRadius()*getRadius());
        System.out.println("둘레 : " + PI*getRadius()*2);
    }
}
