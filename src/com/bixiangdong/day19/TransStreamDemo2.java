package com.bixiangdong.day19;

import java.io.*;

/*
练习：将一个文本数据打印在控制台上
 */
public class TransStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //从文本文件读取数据
//        method_direct();
        method_io();
    }

    public static void method_io() throws IOException {
        //使用带装饰的字节流
        FileInputStream fis = new FileInputStream("Demo4.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufr = new BufferedReader(isr);

        //输出

        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);

        String len = null;
        while ((len = bufr.readLine()) != null) {
            bw.write(len);
            bw.newLine();
            bw.flush();
        }
        bufr.close();
        bw.close();
    }

    private static void method_direct() throws IOException {
        FileReader fr = new FileReader("Demo4.txt");
        BufferedReader bufr = new BufferedReader(fr);

        //输出到控制台 System.out PrintStream 直接输出
        //
        String len = null;
        while ((len = bufr.readLine()) != null) {
            System.out.println(len);
        }
        bufr.close();
    }
}
