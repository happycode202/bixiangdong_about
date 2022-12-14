package com.bixiangdong.day23;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
需求：
客户端发送字符串到服务器，服务器将字符串转换成大写之后返回客户端
 */
public class TransClient {
    public static void main(String[] args) throws IOException {
        //创建socket
        Socket s = new Socket("192.168.1.101", 10005);
        //创建键盘输入流
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line=null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            //将键盘输入流输入的数据传输向服务器
            bufwOut.write(line);
            bufwOut.newLine();
            bufwOut.flush();

            String LineIn = bufrIn.readLine();
            System.out.println(LineIn);

        }
        s.close();
        bufr.close();

    }
}
