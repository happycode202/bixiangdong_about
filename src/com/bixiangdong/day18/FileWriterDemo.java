package com.bixiangdong.day18;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    //需求：新建文件并在文件中写入字符
    public static void main(String[] args) {
        FileWriter fw = null;

        try {
            fw = new FileWriter("demo1.txt");
            fw.write("dkjfldkjfljlkjl");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fw != null) fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
            }
        }
    }
}
