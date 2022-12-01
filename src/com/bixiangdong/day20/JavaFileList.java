package com.bixiangdong.day20;

import sun.reflect.annotation.ExceptionProxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
练习：
将一个指定目录下的java文件的绝对路径，存储到一个文本文件中。
建立一个java文件列表文件

思路：
1. 对指定的目录进行递归
2. 获取递归过程中的所有java文件的路径
3. 将这些路径存储到集合中。
4. 将集合中的数据写入到文件中
 */
public class JavaFileList {
    public static void main(String[] args) throws IOException {
        //获取指定路径的file对象
        File f = new File("/Users/sunhl/IdeaProjects");
        List<File> list = new ArrayList<>();
        //将所有file都存储到list集合中
        fileToList(f, list);
        //创建写入对象的file对象
        File output = new File(f, "javaList.txt");
        listTofile(list, output);
    }

    public static void fileToList(File f, List<File> list) {
        //递归获取所有文件
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                fileToList(file, list);
            } else {
                list.add(file);
            }
        }
    }

    public static void listTofile(List<File> list, File outputFile) throws IOException {
        BufferedWriter bufw = new BufferedWriter(new FileWriter(outputFile));
        for (File file : list) {
            if (file.getName().endsWith(".java")) {
                bufw.write(file.getAbsolutePath());
                bufw.newLine();
                bufw.flush();
            }
        }
        bufw.close();

    }
}

