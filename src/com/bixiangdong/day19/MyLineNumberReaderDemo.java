package com.bixiangdong.day19;

import java.io.FileReader;
import java.io.IOException;

/*
自写一个LineNumberReader

 */
public class MyLineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/com/bixiangdong/day19/BufferedReaderDemo.java");
        MyLineNumberReader mylnr = new MyLineNumberReader(fr);
        String line=null;
        while ((line = mylnr.myReadLine()) != null) {
            System.out.println(line);
        }
        mylnr.myClose();
    }
}
class MyLineNumberReader{
    private FileReader fr;

    MyLineNumberReader(FileReader fr) {
        this.fr=fr;
    }
    //set get 方法
    //myReadLine方法
    public String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch =0;
        while ((ch = fr.read()) != -1) {
            if (ch == '\r') {
                return sb.toString();
            }else {
                sb.append((char) ch);
            }
        }
        if (sb.length() != 0) {
            System.out.println(sb.toString()+"----------------");
            return sb.toString();
        }
        return null;
    }

    public void myClose() throws IOException{
        fr.close();
    }
}