package com.bixiangdong.day18;


import java.io.FileReader;
import java.io.IOException;

/**
 * 读取一个java文件，并打印在控制台上
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("/Users/sunhl/IdeaProjects/bixiangdong_about/src/com/bixiangdong/day18/DateDemo.java");
        char[] buf = new char[1024];
        int num = 0;
        while ((num = fr.read(buf)) != -1) {
            System.out.println(new String(buf,0,num));
        }
        fr.close();
    }
}
