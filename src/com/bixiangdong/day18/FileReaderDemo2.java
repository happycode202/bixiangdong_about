package com.bixiangdong.day18;


import java.io.FileReader;
import java.io.IOException;

/**
 * 第二种方式：通过字符数组进行读取
 */
public class FileReaderDemo2 {
    public static void main(String[] args) throws IOException {
        //定义一个字符数组用来存储读到的字符
        //该read(char[])返回的是读到字符的个数
        FileReader fr = new FileReader("demo.txt");
        char[] buf = new char[1024];
        int num = 0;
        while ((num = fr.read(buf)) != -1) {
            System.out.println(new String(buf, 0, num));
        }
    }
}
