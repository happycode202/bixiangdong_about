package com.bixiangdong.day18;

import java.io.FileReader;

public class FileReaderDemo {
    public static void main(String[] args) throws Exception {
        //创建一个文件读取流对象，和指定名称的文件相关联
        //要保证该文件是已经存在的，如果不存在会发生异常FieNotFoundException
        FileReader fr = new FileReader("demo.txt");
        //调用读取流对象的read方法
        //read()一次读取一个字符，并自动往下读
//        int ch= fr.read();
//        while (true) {
//            int ch = fr.read();
//            if (ch == -1) {
//                break;
        int ch = 0;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();
    }
}
