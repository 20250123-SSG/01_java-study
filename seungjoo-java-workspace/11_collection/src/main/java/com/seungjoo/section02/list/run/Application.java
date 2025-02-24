package com.seungjoo.section02.list.run;

import com.seungjoo.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

//        ArrayList list = new ArrayList();
        List list = new ArrayList(); //다형성 적용하여 상위 레퍼런스로 하위 클래스로 두는게 좋음
        //이렇게 선언하는 것이 더 좋음, 다른 리스트로 변환이 쉽기 때문에

        list.add(10); //인자로 전달된 요소를 리스트 마지막 위치에 추가

        //리스트 내의 요소들을 "[]", ","를 이용하여 하나의 문자열로 합쳐 반환되도록 오버라이딩

        System.out.println(list.toString());

        list.add(1, new Music("APT", "ROSE"));
        System.out.println("list" + list);
        // 장점. 크기에 제약x, 다양한 타입 저장 o, 복잡한 로직x
        // 단, 특정 타입의 데이터만 보관되도록 제한을 두는게 좋음(즉, 타입 지정해서 써라!)

    }

}
