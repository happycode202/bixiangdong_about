package com.bixiangdong.day19;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/*
给读取的输入加上行号
 */
public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("Demo1.txt");
        LineNumberReader lnr = new LineNumberReader(fr);
        String line=null;
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + line);
        }
        lnr.close();

    }
}
