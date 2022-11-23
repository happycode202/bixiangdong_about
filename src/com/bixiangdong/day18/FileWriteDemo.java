package com.bixiangdong.day18;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 学习一下字节流的特点
 * 既然io流是用来操作时距的，那么数据最常见的体现形式是；文件
 * 那么先操作文件为主来演示。
 * <p>
 * 需求：在硬盘上，创建一个文件并写入一些文字数据，找到一个专门用于操作文件的writer子类对象。FileWriter:后缀名是父类名，前缀名是该流对象的功能名
 */
public class FileWriteDemo {
    public static void main(String[] args) throws IOException {
        //创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件
        //而且该文件会被创建到制定的目录下。如果该目录下已有同名文件，将被覆盖
        FileWriter fw = new FileWriter("/Users/sunhl/Downloads/demo.txt");

        //调用write方法，将字符串写入到流中
        fw.write("adbcdkdjflj");
        //刷新流对象中的缓冲区中的数据，
        //将数据存储到目的地中
//        fw.flush();

        //关闭流资源，但是关闭之前会刷新一次内部的缓冲中的数据
        //将数据刷到目的地中。
        //和flush()区别：flush刷新后，流可以继续使用，close刷新后，会将流关闭。
        fw.close();

    }
}
