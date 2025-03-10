package com.kyungbae.section05.naver_api;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        CaptchaController cc = new CaptchaController();

        // 1. 캡차 키 발급
        String captchaKey = cc.getCaptchaKey();

        // 2. 캡차 이미지 받기 (캡차 키 필요) => 다운로드
        cc.downloadCaptchaImg(captchaKey);

        // 3. 사용자에게 값 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print(">> 입력: ");
        String input = sc.nextLine();

        // 4. 사용자 입력값 검증 (캡차 키, 사용자 입력값 필요)
        cc.checkCaptcha(captchaKey, input);

    }
}
