package com.inyong.section01.generic;
/*
제네릭 Generics
클래스 내부에 사용할 타입을 클래스 외부에서 저장하는 기법
클래스 선언부 마지막에 다이아몬드 연산자를 이용하여 작성
다이아몬드 연산자 내부에 작성하는 영문자는 관례상 대문자로 작성

해당 클래스를 사용 및 호출하는 곳에서 타입을 작성하게 됨 => 타입이 결정되서 반영
유의사항 : 타입 지정시 래퍼런스 타입만 가능 (Primitive Type)
T - type
K - key
V - value
E - Element

 */
public class Container<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Container{" +
                "item=" + item +
                '}';
    }
}
