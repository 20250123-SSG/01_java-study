package com.minkook.section02.url;

import java.net.MalformedURLException;
import java.net.URL;

public class Application {
    public static void main(String [] args){
        try {
            URL url = new URL("https://www.example.com/blog/list?page=1&sort=DESC#memo");

            //URL 파씽하기
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getQuery());
            System.out.println(url.getRef());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
