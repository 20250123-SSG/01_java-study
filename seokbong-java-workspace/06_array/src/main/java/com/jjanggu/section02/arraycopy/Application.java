package com.jjanggu.section02.arraycopy;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        ArrayCopy ac = new ArrayCopy();
//        ac.testShallowArrayCopy();
//        ac.testDeepArrayCopy1();
        ac.testDeepArrayCopy2();
//        ac.testDeepArrayCopy3();
//        ac.testDeepArrayCopy4();

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("기존 arr : " + Arrays.toString(arr));
//        ac.testArrayParameter(arr); // 매개변수에서 얕은 복사 진행
        ac.testArrayParameter(arr.clone());
        System.out.println("메소드 실행후 arr" + Arrays.toString(arr));
    }
}
