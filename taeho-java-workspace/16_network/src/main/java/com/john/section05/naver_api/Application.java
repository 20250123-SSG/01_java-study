package com.john.section05.naver_api;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        CaptchaController captchaController = new CaptchaController();

        // 1. 캡차 키 발급
        String captchaKey = captchaController.getCaptchaKey();
        System.out.println(captchaKey);
        // 2. 캡차 이미지 받기
        captchaController.downloadCaptchaImage(captchaKey);

        // 3. 사용자에게 값 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print("캡차 문자 입력: ");
        String captchaInput = sc.nextLine();
        // 4. 사용자 입력값 검증하기
        captchaController.checkCaptcha(captchaKey, captchaInput);
    }
}
