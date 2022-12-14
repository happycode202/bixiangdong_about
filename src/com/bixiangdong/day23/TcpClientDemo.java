package com.bixiangdong.day23;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClientDemo {
    public static void main(String[] args) throws IOException {
        //创建socket，并指定服务器ip，端口
        Socket s = new Socket("192.168.1.100", 10004);

        //获取输出流，并写出数据
        OutputStream out=s.getOutputStream();
        //等待服务端的反馈数据
        out.write("tcp 写出数据".getBytes());

        InputStream is = s.getInputStream();
        int len=0;
        byte[] buf = new byte[1024];
        len=is.read(buf);
        System.out.println(new String(buf, 0, len));
        //关闭socket
        s.close();
    }
}
