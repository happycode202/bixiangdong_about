package com.bixiangdong.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SendClient implements Runnable {
    private DatagramSocket ds;
    public SendClient(DatagramSocket ds) {
        this.ds=ds;
    }
    @Override
    public void run() {
        //键盘录入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while (true) {
            try {
                if (!((line = bufr.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //将键盘录入的内容打包
            byte[] buf = line.getBytes();
            DatagramPacket dp = null;
            try {
                dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.255"), 10001);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            //发送数据
            try {
                ds.send(dp);
            } catch (IOException e) {
                throw new RuntimeException("发送失败");
            }

        }

    }
}
