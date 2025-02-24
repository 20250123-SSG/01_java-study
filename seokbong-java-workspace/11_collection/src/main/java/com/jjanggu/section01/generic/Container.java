package com.jjanggu.section01.generic;

/*
    ## 제네릭 ##
    1. Generics
    2. 클래스 내부에서 사용할 타입을 클래스 외부에서 지정하는 기법
    3. 클래스 선언부 마지막에 다이아몬드 연산자를 이용하여 작성
       다이아몬드 연산자 내부에 작성하는 영문자는 관례상 대문자로 작성
       ex) T(Type), K(key), V(Value), E(Element)
    4. 해당 클래스를 사용 및 호출하는 곳에서 타입을 작성하게 됨 => 타입이 결정되서 반영
    5. 유의사항 : 타입 지정시 레퍼런스 타입만 가능 (즉, primitive Type 제시 불가)
 */

public class Container<T> {

    private T item; // T 타입의 item을 가질 수 있는 필드

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
