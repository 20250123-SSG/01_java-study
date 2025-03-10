package com.sotogito.section04.url_encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

public class Application {
    public static void main(String[] args) {
        String url = "http://www.google.com/search?query=sotogito";

        try {
            String encoded = URLEncoder.encode(url, "UTF-8");
            System.out.println(encoded);

            String decoced = URLDecoder.decode(encoded, "UTF-8");
            System.out.println(decoced);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
