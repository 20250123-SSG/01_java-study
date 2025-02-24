package com.podoseee.Practice2.dto;

import static java.lang.Math.PI;

public class Rectangle extends Point{
    private int width;
    private int height;

    public Rectangle(){}

    public Rectangle(int x, int y, int width, int height){
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }


    public void draw(){
        System.out.println("x좌표 : " + getX() + "y좌표 : " + getY());
        System.out.println("면적 : " + getHeight()*getWidth());
        System.out.println("둘레 : " + (getWidth()+getHeight())*2);
    }
}
