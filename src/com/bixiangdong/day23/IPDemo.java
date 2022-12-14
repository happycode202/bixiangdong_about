package com.bixiangdong.day23;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress ia = InetAddress.getLocalHost();
//        System.out.println("addredd" +"..."+ ia.getHostAddress());
//        System.out.println("name" +"..."+ ia.getHostName());

        InetAddress ia = InetAddress.getByName("www.baidu.com");
        System.out.println(ia.getHostName() + "..." + ia.getHostAddress());
    }
}
