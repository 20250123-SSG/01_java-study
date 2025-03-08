package com.podoseee.section01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Application {
    public static void main(String[] args) {
        /*
            ## java.net.InetAddress #
            IP 주소와 호스트 이름을 관리하는 클래스
         */

        try {
            InetAddress addr = InetAddress.getByName("www.google.com");
            System.out.println("addr: " + addr);
            System.out.println("IP Address: " + addr.getHostAddress());
            System.out.println("Domain Address: " + addr.getHostName());

            System.out.println("=====================================");

            InetAddress[] addrList = InetAddress.getAllByName("www.naver.com");
            for(InetAddress address : addrList){
                System.out.println("네이버 IP 주소: " + address.getHostAddress());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
