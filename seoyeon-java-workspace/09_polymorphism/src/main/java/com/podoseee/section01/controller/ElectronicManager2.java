package com.podoseee.section01.controller;

import com.podoseee.section01.dto.Electronic;

public class ElectronicManager2 { // 다형성 적용 후
    
    // 부모타입 배열로 모든 자식 인스턴스 가지도록
    private Electronic[] elec = new Electronic[3];
    private int count = 0;

    // 제품 추가용 메소드
    public void insert( Electronic any ){
        elec[count++] = any;
    }

    // 제품 조회용 메소드
    public Electronic select(int index){
        return elec[index];
    }

      /*
        다형성 장점3. 확장성이 좋은 코드를 작성할 수 잇음
                      (후에 새로운 전자제품 클래스가 추가되어도 새로이 메소드를 추가할 필요 없음)
        다형성 장점4. 결합도를 낮춰 유지보수성을 증가시킬 수 있음
                      (부모 타입만을 매개변수 및 반환타입으로 둬서 특정 자식 타입을 의존하지 않게 만듬)
     */
}
