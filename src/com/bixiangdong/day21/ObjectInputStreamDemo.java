package com.bixiangdong.day21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException{
        writeObj();
    }
    //创建objectinputStream对象，并下入对象数据到文件中
    public static void writeObj() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
        oos.writeObject(new Person("lisi", 22));
        oos.close();
    }
}
