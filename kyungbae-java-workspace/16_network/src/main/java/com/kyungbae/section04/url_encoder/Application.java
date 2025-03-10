package com.kyungbae.section04.url_encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Application {
    public static void main(String[] args) {
        String url = "https://www.naver.com/search?query=김밥천국";

        try {
            String encoded = URLEncoder.encode(url, "UTF-8");
            System.out.println(encoded);

            String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
            System.out.println(decoded);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
