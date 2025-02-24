package com.john.section01.generic;

/*
    제네릭(Generics)
    - 때에 따라서 필드에 다양한 타입을 받고 싶을 때 사용
    - 클래스 내부에 사용할 타입을 클래스 외부에서 지정하는 기법
    - 클래스 선언부 마지막에 <> 연산자를 이용해서 작성, 관례상 <>내부에 작성하는 영문자는 대문자
        => T(Type), K(Key), V(Value), E(Element) ...
    - 클래스를 사용, 호출하는 곳에서 타입을 작성하게 됨
    - 타입 지정시 레퍼런스 타입만 가능 (기본 자료형(Primitive type 제시 불가)

 */
public class Container<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    // 어떤 타입이 들어올 지 모르지만 문자열로 반환하도록 고정
    public String toString(){
        return String.valueOf(item);
    }
}
