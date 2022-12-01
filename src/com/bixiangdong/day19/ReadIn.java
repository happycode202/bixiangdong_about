package com.bixiangdong.day19;

import sun.reflect.generics.repository.ConstructorRepository;

import java.io.IOException;
import java.io.InputStream;

/*
字符流
FileReader
FileWrite

BufferedFileReader
buffredfileWriter

字节流
FileInputStream
FileOutputStream

BufferedFileInputStream
BufferedFileOutputStream

system.out:对应标准输出设备，控制台
System.in:字节读取流对象，标准输入设备：键盘

 */
public class ReadIn {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
//        int by = in.read();
//        System.out.println(by);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int ch = in.read();
            if (ch == '\n') {
                String s = sb.toString();
                if ("over".equals(s)) {
                    break;
                }
                System.out.println(s.toUpperCase());
                sb.delete(0, sb.length());//清空缓冲区
            } else {
                sb.append((char) ch);
            }

        }
    }
}
