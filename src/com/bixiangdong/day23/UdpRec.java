package com.bixiangdong.day23;

import java.io.IOException;
import java.net.*;

public class UdpRec {
    public static void main(String[] args) throws IOException {
        //创建socket服务
        DatagramSocket ds = new DatagramSocket(10000);
        while (true) {
            //创建数据包，存储接收到的数据
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
//            ds.close();
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip + "::" + data);
        }
    }
}
