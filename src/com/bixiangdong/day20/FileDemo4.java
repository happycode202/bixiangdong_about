package com.bixiangdong.day20;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
列出指定目录下文件或者文件夹，包含子目录中的内容。
也就是列出指定目录下所有内容。

因为目录中还有目录，只要使用同一个列出目录功能的函数完成即可。
在列出过程中出现的还是目录的话，还可以再次调用本功能。
也就是函数自身调用自身。
这种表现形式，或者编程手法，称为递归。

递归要注意：
1，限定条件。

2，要注意递归的次数。尽量避免内存溢出。
 */
public class FileDemo4 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/sunhl/Downloads/rime-ice");
        List<File> list = new ArrayList<>();
        List<File> dir = getDir(file, list);

        //输出到到文件，使用fileWriter
        //高速写出，需要使用buffer
        BufferedWriter bufw = new BufferedWriter(new FileWriter("/Users/sunhl/Downloads/test/demo.txt"));
        //将结果输出到控制台上
        //将list集合中的数据取出，并输出到控制台
        for (File f : dir) {
//            System.out.println(f);
//            将结果输出到文件
            //写入f的绝对地址值
            bufw.write(f.getAbsolutePath());
            //新行
            bufw.newLine();
            //刷新缓冲区
            bufw.flush();
        }
        //关闭流
        bufw.close();
        System.out.println(getSum(100));
    }

    /**
     *
     * @param file
     * @param list
     * @return
     */
    public static List<File> getDir(File file, List<File> list) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getDir(f,list);
            } else
                list.add(f);
        }
        return list;
    }

    //使用递归计算前100的值
    public static int getSum(int max){
        if (max ==1) {
            return 1;
        }
        return max+getSum(max-1);
    }
}
