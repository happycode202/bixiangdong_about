package com.bixiangdong.day23;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceClient implements Runnable{
    private DatagramSocket ds;
    public ReceClient(DatagramSocket ds){
        this.ds=ds;
    }

    @Override
    public void run() {
        while (true) {
            //定义用来存储数据的变量
            byte[] buf = new byte[1024];
            //接收数据包
            DatagramPacket dp = new DatagramPacket(buf,buf.length);
            try {
                ds.receive(dp);
                InetAddress ip = dp.getAddress();
                String data = new String(dp.getData());
                System.out.println(ip+"......"+data);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
