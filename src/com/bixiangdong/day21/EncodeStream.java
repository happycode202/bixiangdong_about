package com.bixiangdong.day21;

import java.io.*;

/*
编码
 */
public class EncodeStream {
    public static void main(String[] args) throws IOException {
//        writeText();
        readText();
    }
    public static void writeText() throws IOException {
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream("utf.txt"),"GBK"); os.write("你好");
        os.close();
    }
    public static void readText() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("utf.txt"), "UTF-8");
        char[] buf = new char[10];
        int len = isr.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(str);
        isr.close();
    }
}
