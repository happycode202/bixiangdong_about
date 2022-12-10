package com.bixiangdong.day21;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/*
ByteArrayStream
类比较特殊，没有动用系统的资源，input是字节数组，output不是硬盘上的文件，而是ArrayStream中封装的可变数组
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) {
        //数据源
        ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEF".getBytes());
        //数据的存储地
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len=0;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }
        System.out.println(bos.size());
        System.out.println(bos.toString());
    }
}
