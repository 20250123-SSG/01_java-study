package com.pch.section01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Application1 {
    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println(address);
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
        } catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
