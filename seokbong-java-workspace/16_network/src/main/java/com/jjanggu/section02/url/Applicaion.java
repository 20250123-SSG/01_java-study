package com.jjanggu.section02.url;

import java.net.MalformedURLException;
import java.net.URL;

public class Applicaion {
    public static void main(String[] args) {
        /*
            ## java.net.url ##
            사용하고자 하는 자원(리소스)에 대한 위치(포인터)를 니영히ㅑㅇ
         */

        try {
            URL url = new URL("https://www.example.com:8080/blog/list?page=1&soert=DESC#memo");

            // URL 파싱하기
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
