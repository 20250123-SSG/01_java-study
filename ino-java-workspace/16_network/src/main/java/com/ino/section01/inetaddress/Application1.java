package com.ino.section01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Application1 {
    public static void main(String[] args) {
        try {

            InetAddress addr = InetAddress.getByName("www.google.com");
            System.out.println("addr: " + addr);
            System.out.println("Ip addr : " + addr.getHostAddress());
            System.out.println("Domain addr : " + addr.getHostName());

            InetAddress[] naverAddrs = InetAddress.getAllByName("www.naver.com");
            for (InetAddress address : naverAddrs) {
                System.out.println(address);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
