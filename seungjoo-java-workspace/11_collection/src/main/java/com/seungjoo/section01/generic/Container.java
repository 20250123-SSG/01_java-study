package com.seungjoo.section01.generic;

public class Container<T> {
    private T item;  //컨테이너 객체 생성시 타입을 지정할 것임. T 타입의 item을 가질 수 있는 필드

    public T getItem(){
        return item;
    }
    public void setItem(T item){
        this.item = item;
    }
    public String toString(){
        return String.valueOf(item);
    }




}
