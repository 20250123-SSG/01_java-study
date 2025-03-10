package com.ino.section04.url_encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Application {
    public static void main(String[] args) {
        String url = "https://www.naver.com/search?query=ino";

        try {
            String encoded = URLEncoder.encode(url, "UTF-8");
            System.out.println(encoded);
            System.out.println(URLDecoder.decode(encoded, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
