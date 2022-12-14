package com.bixiangdong.day23;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {
    public static void main(String[] args) throws IOException {
        //服务端的tcp套接字
        ServerSocket ss = new ServerSocket(10005);
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress() + "....connected");
        //获取客户端发送的输入流，并获取其中的数据
        BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //获取输出流
        BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String input = null;
        while ((input = bufr.readLine()) != null) {
            bufwOut.write(input.toUpperCase());
            bufwOut.newLine();
            bufwOut.flush();
        }

        s.close();
        ss.close();
    }
}
