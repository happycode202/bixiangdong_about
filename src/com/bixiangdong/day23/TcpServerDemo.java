package com.bixiangdong.day23;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo {
    public static void main(String[] args) throws IOException {
        //开启服务器的serverSocket
        ServerSocket ss = new ServerSocket(10004);
        Socket s = ss.accept();

        //获取socket中的InetAddredd
        InetAddress ia = s.getInetAddress();
        System.out.println(ia.getHostAddress() + "...connected");

        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len=0;
        len = in.read(buf);
        System.out.println(new String(buf, 0, len));

        //回应客户端
        OutputStream out = s.getOutputStream();
        out.write("服务器的回应".getBytes());
        s.close();
    }
}
