package com.kyungbae.section01.generic;

public class Container <T> {

    private T item; // T 타입의 item 을 가질 수 있는 필드

    public T getItem(){
        return item;
    }

    public void setItem(T item){
        this.item = item;
    }

    @Override
    public String toString(){
        return String.valueOf(item); // 어떤타입이 들어와도 String으로 변환해서 반환
    }

}
