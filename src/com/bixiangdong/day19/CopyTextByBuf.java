package com.bixiangdong.day19;

import java.io.*;

/*
通过缓冲区复制一个java文件
1. 复制文件需要读写操作，又由于要使用缓冲区，则直接创建bufferedReader和bufferedWriter对象
2. 读写操作
3. 关闭流
 */
public class CopyTextByBuf {
    public static void main(String[] args) {
        BufferedReader bufr = null;
        BufferedWriter bufw = null;

        try {
            bufr = new BufferedReader(new FileReader("src/com/bixiangdong/day19/BufferedReaderDemo.java"));
            bufw = new BufferedWriter(new FileWriter("src/com/bixiangdong/day19/Copy.txt"));
            String line = null;
            while ((line = bufr.readLine()) != null) {
                bufw.write(line);
                bufw.newLine();
                bufw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("读写失败");
        } finally {
            try {
                if (bufr != null)
                    bufr.close();
            } catch (IOException e) {
                throw new RuntimeException("读取关闭失败");
            }
            try {
                if (bufw != null)
                    bufw.close();
            } catch (IOException e) {
                throw new RuntimeException("写入关闭失败");
            }
        }

    }
}
