package com.bixiangdong.day18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
复制的原理：
其实就是将c盘中的文件数据存储到d盘中的一个文件

1. 在d盘创建一个文件，用于存储c盘文件中的数据
2. 定义一个读取流和c盘文件关联
3. 通过不断的读写完成数据的存储
4. 关闭资源
 */
public class CopyText {
    public static void main(String[] args) throws IOException{
//        copy_1();
        copy_2();
    }
    //一次读取一个字符数组
    public static void copy_2() throws IOException{
        FileWriter fw =null;
        FileReader fr = null;
        try {
            fw = new FileWriter("src/com/bixiangdong/day18/MathDemo_copy.java");
            fr = new FileReader("src/com/bixiangdong/day18/MathDemo.java");
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                fw.write(buf, 0, len);
            }
        } catch (Exception e) {
            throw new RuntimeException("读写失败");
        }
        finally {

            if (fw != null) {

                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    //从c盘读一个字符，就往d盘写一个字符
    public static void copy_1() throws IOException {
        FileWriter fw = null;
        FileReader fr = null;

        fw = new FileWriter("src/com/bixiangdong/day18/MathDemo_copy.java");
        fr = new FileReader("src/com/bixiangdong/day18/MathDemo.java");
        int ch=0;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fw.close();
        fr.close();
    }
}

