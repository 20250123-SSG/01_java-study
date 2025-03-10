package com.kyungbae.section01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        try {
            InetAddress addr = InetAddress.getByName("www.google.com");
            System.out.println("addr: " + addr);
            System.out.println("IP Address: " + addr.getHostAddress());
            System.out.println("Domain Address: " + addr.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------");

        try {
            InetAddress[] addrList = InetAddress.getAllByName("www.naver.com");
            Arrays.stream(addrList).forEach(System.out::println);
            for (InetAddress a : addrList){
                System.out.println("네이버 IP 주소: " + a.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

}
