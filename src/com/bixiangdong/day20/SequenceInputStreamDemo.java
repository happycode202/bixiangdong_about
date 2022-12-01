package com.bixiangdong.day20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/*
需求：
将三个不同的流合并成一个，并将流内的数据写入到文件中
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        Vector<FileInputStream> v = new Vector<>();
        v.add(new FileInputStream("1.txt"));
        v.add(new FileInputStream("2.txt"));
        v.add(new FileInputStream("3.txt"));
        Enumeration<FileInputStream> elements = v.elements();
        SequenceInputStream sis = new SequenceInputStream(elements);
        //输出流，写入数据到文件4.txt
        FileOutputStream fos = new FileOutputStream("4.txt");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        sis.close();
        fos.close();

    }
}
