package com.bixiangdong.day18;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 演示对已有文件的续写
 */
public class FileWriteDemo3 {
    public static void main(String[] args) {
        FileWriter fw =null;
        //传递一个true参数，代表不覆盖已有的文件，并在已有文件的末尾处进行续写
        try {
            fw = new FileWriter("demo.txt", true);
            fw.write("hhhhhhhhhhhhhh\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
        }
        try {
            if (fw!=null)
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
