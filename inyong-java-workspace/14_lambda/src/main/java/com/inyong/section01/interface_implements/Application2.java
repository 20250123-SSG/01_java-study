package com.inyong.section01.interface_implements;

public class Application2 {
    public static void main(String[] args) {


    /*
    별도의 구현 클래스를 만들지 않고
    인터페이스 생성시 바로 구현하는 방식

    public interface A {
    // 추상메소드
    }


    A a = new A(){
    // 사용 목적에 맞춰 오버라이딩 =->  메소드 기능 완성
    }

    구현 클래스를 별도로 만들어둘 필요 없이 필요할때 바로 구현해서 쓰면됨
    단점 : 해당 목적의 기능을 다시 써야될 경우 매번 익명클래스 방식으로 새로이 정의 (재사용 불가)
     */

    Calculator sup = new Calculator() {
        @Override
        public int cal(int num1, int num2) {
            return num1 * num2;
        }
    };
    System.out.println(sup.cal(5,7));


}}
