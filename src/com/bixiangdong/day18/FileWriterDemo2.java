package com.bixiangdong.day18;

import jdk.internal.org.objectweb.asm.commons.TryCatchBlockSorter;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.FileWriter;
import java.io.IOException;

/**
 * IO异常的处理方式
 */
public class FileWriterDemo2 {
    public static void main(String[] args) {
            FileWriter fw=null;
        try {
            fw = new FileWriter("demo.txt");
            fw.write("dojfodijfoiaj");
            fw.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        finally {
            try {
            if (fw!=null)
                fw.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }


    }
}
