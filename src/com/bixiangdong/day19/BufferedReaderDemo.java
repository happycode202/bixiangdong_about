package com.bixiangdong.day19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
字符读取流缓冲区
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("Demo1.txt");
        BufferedReader bufr = new BufferedReader(fr);
        String line=null;
        //每次读取一行，只要reeadLine返回值不为null，就继续读取
        while ((line = bufr.readLine()) != null) {
            System.out.println(line);
        }
        bufr.close();
    }
}
