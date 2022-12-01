package com.bixiangdong.day20;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 练习
 * 将一个指定目录下的所有java文件的绝对路径，存储到一个文本文件中。
 * 建立一个java文件列表文件。
 */
public class JavaFileList1_1 {
    public static void main(String[] args) throws IOException{

//        讲问题拆分成两个部分：1.获取指定目录下符合要求的文件集合 2. 将集合中的数据写入到文件中
        File file = new File("/Users/sunhl/Downloads/test");
        List<File> list = new ArrayList<>();
        List<File> files = gerFiles(file, list);
        writeToFile(list, "/Users/sunhl/Downloads/test/output.txt");
    }

    /**
     *
     * @param file 制定目录的file对象
     * @param list 用来存储返回数据的List对象
     * @return 制定目录中java文件的file对象集合
     */
    public static List<File> gerFiles(File file,List<File> list){
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                gerFiles(f, list);
            }else {
                if (f.getName().endsWith(".java")) {
                    list.add(f);
                }
            }
        }
        return list;
    }

    /**
     *
     * @param list 装有file对象集合
     * @param str  写入文件的路径字符串
     */
    public static void writeToFile(List<File> list, String str1) throws IOException {
        BufferedWriter bufw = new BufferedWriter(new FileWriter(str1));
        StringBuilder sb = new StringBuilder();
        for (File f : list) {
            bufw.write(f.getAbsolutePath());
            bufw.newLine();
            bufw.flush();
        }
        bufw.close();

    }

}
