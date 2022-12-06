package com.bixiangdong.day21;

import java.io.*;

/*
需求：
将对像的数据存储到本地，读取并显示在控制台
 */
public class SerializableDemo {
    public static void main(String[] args) throws Exception{
//        writeObject();
        readObj();
    }

    public static void readObj() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
        Person p=(Person)ois.readObject();
        System.out.println(p);
        ois.close();
    }
    public static void writeObject() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
        oos.writeObject(new Person("lisi", 11));
        oos.close();
    }
}
