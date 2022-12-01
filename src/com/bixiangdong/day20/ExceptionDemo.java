package com.bixiangdong.day20;

import sun.awt.geom.AreaOp;

import java.io.File;
import java.io.IOException;

/*
 */
public class ExceptionDemo {
    public static void main(String[] args) throws IOException {
        method_1();

    }
    public static void method_1()throws IOException{
        File f = new File("file.txt");//这段代码知识在代码中创建对象，并没有实际创建文件。
        System.out.println("create" + f.createNewFile());
        System.out.println("path:" + f.getPath());
        System.out.println("abs:" + f.getAbsolutePath());
        System.out.println("lenth:" + f.length());
        System.out.println("parent:" + f.getPath());
    }
}
