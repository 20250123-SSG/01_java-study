package com.ibe6.section05.naver_api;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        CaptchaController cc = new CaptchaController();

        // 1. 캡차 키 발급
        String captchaKey = cc.getCaptchaKey();

        // 2. 캡차 이미지 받기 (1번과정에서의 키 필요)
        cc.downloadCaptchaImg(captchaKey);

        // 3. 사용자에게 값 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print("캡차 문자: ");
        String input = sc.nextLine();

        // 4. 사용자 입력값 검증하기 (1번과정의 키, 3번ㄱ놔정의 사용자 입력값 필요)
        cc.checkCaptcha(captchaKey, input);
    }
}
