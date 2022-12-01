package com.bixiangdong.day20;

import java.io.File;
import java.io.IOException;

/*
列出指定目录下文件或者文件夹，包含子目录中的内容。
也就是列出指定目录下的所有内容

递归:
因为目录中还有目录，只要使用同一个列出目录功能的函数完成即可。在列出过程中出现的还是目录的话，还可以在此调用本功能。
也就是函数自己调用自己
这在编程中称之为 递归

递归要注意：
 */
public class FileDemo3 {
    public static void main(String[] args) {
        File f = new File("/Users/sunhl/Downloads/rime-ice");
//        showDir(f);
//        showDir_2(f);
//        System.out.println(sum_method(1000));
        showDir_1(f);
    }

    //用递归求和
    //本质是利用sum_n=sum_(n-1)+a_n;n的取值要限制在n>=1
    public static int sum_method(int i) {
        if (i == 1) {
            return i;
        }
        return i + sum_method(i - 1);
    }

    //高级for循环
    public static void showDir(File f) {
        File[] files = f.listFiles();
        for (File file :
                files) {
            if (file.isDirectory()) {
                showDir(file);
                System.out.println(file);
            } else {
                System.out.println(file);
            }
        }
    }

    public static void showDir_2(File file) {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                showDir_2(files[i]);
            }
            System.out.println(files[i]);
        }
    }

    //遍历给定目录下的文件文件夹,并打印在控制台上
    public static void showDir_1(File file) {
        File[] files = file.listFiles();
        for (File f:files ) {
            if (f.isDirectory()) {
                showDir_1(file);
            }else
                System.out.println(f);
        }
    }
}
