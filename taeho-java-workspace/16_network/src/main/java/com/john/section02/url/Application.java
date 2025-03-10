package com.john.section02.url;

/*
    # URL
    - 사용하고자 하는 자원(리소스)에 대한 위치(포인터)를 나타냄

 */

import java.net.MalformedURLException;
import java.net.URL;

public class Application {
    public static void main(String[] args) {

        URL url = null;

        try {
            url = new URL("https://www.example.com:8080/blog/list?page=1&sort=DESC#memo");

            // URL parsing
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getQuery());
            System.out.println(url.getRef());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
