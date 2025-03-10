package com.sotogito.section01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {
        /**
         * InetAddress
         */

        try {
            InetAddress address = InetAddress.getByName("www.google.com");

            System.out.println(address);
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());

            InetAddress[] addrList = InetAddress.getAllByName("www.naver.com");
            Arrays.stream(addrList)
                    .forEach(a -> System.out.println(a.getHostAddress()));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
