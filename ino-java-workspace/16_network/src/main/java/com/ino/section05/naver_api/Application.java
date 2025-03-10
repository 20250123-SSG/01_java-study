package com.ino.section05.naver_api;

public class Application {
    public static void main(String[] args) {
        CaptchaController cc = new CaptchaController();
        String captchKey = cc.getCaptchaKey();
        cc.getCaptchaImage(captchKey);
    }
}
