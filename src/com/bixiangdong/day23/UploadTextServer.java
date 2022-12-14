package com.bixiangdong.day23;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
文件上传服务器
 */
public class UploadTextServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(10006);
        Socket s = ss.accept();
        //服务端连接成功，服务端输出connected到控制台
        System.out.println(s.getInetAddress().getHostAddress()+"connected");
        //获取socket中的输入流
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //写入server.txt文件的输出流
        PrintWriter pw = new PrintWriter(new FileWriter("server.txt"), true);
        String line=null;
        while ((line = bufrIn.readLine()) != null) {
            pw.println(line);
        }

//        Thread.sleep(3000);
        //告诉客户端传输成功
        PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
        System.out.println("run");
        pwOut.println("上传成功");


        pwOut.close();
        s.close();
        ss.close();
    }
}
