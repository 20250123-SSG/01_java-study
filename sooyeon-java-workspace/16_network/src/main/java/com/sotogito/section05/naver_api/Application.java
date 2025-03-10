package com.sotogito.section05.naver_api;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CaptchaController cc = new CaptchaController();
        /// 1. 캡차 키 발급
        String captchaKey = cc.getCaptchaKey();
        /// 2. 캡차 이미지 받기 - 파일로 다운로드
        cc.downloadCaptcha(captchaKey);
        /// 3. 사용자에게 값 입력받기
        System.out.println("캡차 문자 입력하세요.");
        String input = sc.nextLine();
        /// 4. 사용자 입력값이 맞는지 검증(1번 과정의 키, 3번 과정의 사용자 입력값 필요)
        cc.checkCaptcha(captchaKey, input);





    }
}
