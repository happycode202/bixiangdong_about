package com.bixiangdong.day19;

import java.io.*;

//带缓存的字节流
public class BufferedStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("fox.txt"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("Demo4.txt"));
        int len = 0;
        while ((len = bufis.read()) != -1) {
            bufos.write(len);
        }
        bufis.close();
        bufos.close();

    }
}
