package com.bixiangdong.day19;

import sun.security.util.Length;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
字符流：
FileReader
FileWriter

BufferedReader
BufferedWriter

字节流：
InputStream OutputStream

需求：想要操作图片数据，这时就要用到字节流

 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
//        writeFile();
        readFile_3();
    }

    //输入流，创建一个和输入文件一样大小的数组
    public static void readFile_3() throws IOException{
        FileInputStream fis = new FileInputStream ("fox.txt");
        byte[] buf = new byte[fis.available()];
        int read = fis.read(buf);
        System.out.println(new String(buf,0,read));
        fis.close();
    }
    //输入流，每次读取一个字节数组
    public static void read_file2()throws IOException{
        FileInputStream fis = new FileInputStream ("fox.txt");
        byte[] buf = new byte[1024];
        int lenth=0;
        while ((lenth = fis.read(buf)) != -1) {
            System.out.println(new String(buf,0,lenth));
        }
        fis.close();
    }
    //输入流，每次读取一个字节
    public static  void read_file1() throws IOException{
        FileInputStream fis = new FileInputStream("fox.txt");
        int b = 0;
        while ((b = fis.read()) != -1) {
            System.out.println((char) b);
        }
        fis.close();


    }
    public static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("fox.txt");
        fos.write("jfoidjfoai".getBytes());
        fos.close();
    }

}
