package com.younggalee.section01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        /*
            ## java.net.InetAddress ##
            IP주소와 호스트 이름을 관리하는 클래스
        */
        // new 생성불가, static 메소드 이용
        try {
            InetAddress addr = InetAddress.getByName("www.google.com");
            System.out.println(addr); // 호스트이름 + ip주소
            System.out.println(addr.getHostAddress()); // ip주소만
            System.out.println(addr.getHostName()); // 호스트이름만

            System.out.println();
            InetAddress[] addrList = InetAddress.getAllByName("www.naver.com");
            Arrays.stream(addrList).forEach(System.out::println);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
