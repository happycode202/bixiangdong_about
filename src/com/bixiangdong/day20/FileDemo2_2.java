package com.bixiangdong.day20;

import java.io.File;

public class FileDemo2_2 {
    public static void main(String[] args) {
//        listRootsDemo();
        File file = new File("/Users/sunhl/Downloads/");
        getNameList(file);

    }

    //获取指定路径下文件名的方法
    public static void getNameList(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getName()+f.length());
        }
    }
    //test function
    public static void method_2(){
        File file = new File("/Users/sunhl/Downloads/test/t2/demo.java");
        file.exists();
        file.isFile();
        file.isDirectory();
        file.getName();
        file.getAbsoluteFile().getAbsolutePath();
        file.getAbsolutePath();
        file.getPath();//获取相对路径
        file.getPath();//获取文件的父目录/如果是相对路径，返回null，如果是绝对路径返回上一层目录。
    }
    //test function
    public static void method_1(){
        //各种创建file对象的方法
        File file = new File("/Users/sunhl/Downloads/test");
        File f2 = new File(file, "txt.java");
        File f3 = new File("/Users/sunhl/Downloads/", "txt.java");
        //还可以通过f.mkdirs()方法连续创建目录文件
    }
//    listRoo
    public static void listRootsDemo(){
        File f = new File("/Users/sunhl/Downloads/test");
        File[] files = File.listRoots();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
