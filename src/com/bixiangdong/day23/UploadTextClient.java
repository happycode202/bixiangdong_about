package com.bixiangdong.day23;

import java.io.*;
import java.net.Socket;

/*
文件上传客户端
 */
public class UploadTextClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket s = new Socket("192.168.1.101", 10006);
        //创建上传文件的读取流 被上传的文件stu.txt
        BufferedReader bufr = new BufferedReader(new FileReader("stu.txt"));
        //创建文件的写出流
        PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
        // 写出到服务器
        String line=null;
        while ((line = bufr.readLine()) != null) {
            pwOut.println(line);
        }
        //关闭输出流
        s.shutdownOutput();

        Thread.sleep(1001);
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String s1 = bufrIn.readLine();
        System.out.println(s1);
        //关闭流
        bufr.close();
        s.close();
    }
}
