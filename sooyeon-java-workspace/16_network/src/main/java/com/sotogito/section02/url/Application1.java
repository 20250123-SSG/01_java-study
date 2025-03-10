package com.sotogito.section02.url;

import java.net.MalformedURLException;
import java.net.URL;

public class Application1 {
    public static void main(String[] args) {
        /**
         * URL
         * 사용하고자 하는 자원에 대한 위치를 나 타냄
         */

        try {
            URL url = new URL("https://www.sotogito.com:8080/blog/list?apge=1&sort=DESC#memo");

            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());
            System.out.println(url.getRef());
            System.out.println(url.toExternalForm());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
