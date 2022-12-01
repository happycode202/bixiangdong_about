package com.bixiangdong.day19;

/*
自己实现一个BufferedReader类
需求分析：
1. buf类需要在创建的时候传入一个filereader对象
2. 实现readLine()方法.
 */

import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderDeo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/com/bixiangdong/day19/Copy.txt");
        MyBufferedReader mybuf = new MyBufferedReader(fr);
        System.out.println("____________________________");
        String len = null;
        while ((len = mybuf.myReadLine()) != null) {
            System.out.println(len);
        }
        mybuf.myClose();
    }
}

class MyBufferedReader {
    private FileReader fr;

    MyBufferedReader(FileReader fr) {
        this.fr = fr;
    }

    //实现readline方法，读到\r\n结束读取,并返回字符串
    public String myReadLine() throws IOException {
        //创建储存读取内容的StringBuffer
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        //一只读直到行尾
        while ((ch = fr.read()) != -1) {
            //不能吧读取到的\r\n也存储到文件中，因为不同的系统换行不同，需要用java的换行方法替代
            if (ch == '\r') {
                continue;
            }
            //读取到\n说明该行读取结束，要将读取到的字节数组全部返回
//            if (ch == '\n') {
//                return sb.toString();
//            }
            sb.append((char) ch);
        }
        if (sb.length() != 0) {
            return sb.toString();
        }
        return null;
    }

    public void myClose() throws IOException {
        fr.close();
    }

}