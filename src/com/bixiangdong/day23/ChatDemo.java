package com.bixiangdong.day23;

import java.net.DatagramSocket;

/*
实现一个简单的聊天软件
 */
public class ChatDemo {
    public static void main(String[] args) throws Exception{
        DatagramSocket send = new DatagramSocket();
        DatagramSocket rece = new DatagramSocket(10001);
        new Thread(new SendClient(send)).start();
        new Thread(new ReceClient(rece)).start();
    }
}
