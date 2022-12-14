package com.bixiangdong.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UdpSend {
    public static void main(String[] args) throws IOException {
        //创建udp服务
        DatagramSocket ds = new DatagramSocket();
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        //创建文件包，并将需要发送的文件打包
        while ((line = bufr.readLine()) != null) {
            if (line.equals("over")) {
                break;
            }
            DatagramPacket dp = new DatagramPacket(line.getBytes(), line.length(), InetAddress.getByName("192.168.1.100"), 10000);

            ds.send(dp);
        }
        bufr.close();
        ds.close();
    }
}
