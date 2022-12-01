package com.bixiangdong.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
用于记录应用程序运行次数
如果使用次数达到，那么给出注册提示

很容易想到：计数器

 */
public class RunCount {
    public static void main(String[] args) throws IOException {
        File file = new File("count.init");
        if (!file.exists()) {
            file.createNewFile();
        }
        //读取配置文件中的配置到Properties对象中
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        int count=0;
        String value=prop.getProperty("times");
        if (value != null) {
            count = Integer.parseInt(value);
            if (count >= 5) {
                System.out.println("超过次数，请付费");
            }
        }
        count++;
        prop.setProperty("times", count+"");
        FileOutputStream fos = new FileOutputStream(file);
        prop.store(fos, "");

        fis.close();
        fos.close();
    }

}
