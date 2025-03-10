package com.john.section01.inetaddress;

import java.net.*;
/*
    # InetAddress
    - IP주소와 호스트 이름을 관리하는 클래스
 */
public class Application {
    public static void main(String[] args) {
        try{
            InetAddress addr = InetAddress.getByName("www.google.com");
            System.out.println("addr = " + addr);
            System.out.println("IP Address = " + addr.getHostAddress());
            System.out.println("Host Name(Domain Address) = " + addr.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println("=====================");

        try{
            InetAddress[] addr2 = InetAddress.getAllByName("www.naver.com");
            System.out.println("addr2 = " + addr2);
            for (InetAddress addr : addr2) {
                System.out.println("IP Address = " + addr.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
