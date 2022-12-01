package com.bixiangdong.day20;

import java.io.*;
import java.util.Properties;

/*
需求：
读取本地配置文件，修改部分配置，并保存到原文件
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        Properties pro = new Properties();
        File file = new File("info.init");
//        InputStream fis = null;
//        try {
//            fis = new FileInputStream(file);
//            //读取流内的配置到Properties对象中
//            pro.load(fis);
//            System.out.println(pro);
//            //修改对象中的配置
//            pro.setProperty("lisi", "11");
//            //将配置修改后的配置写入到原配置文件中
//            pro.store(new FileOutputStream("info.init"), "diyicixiugai");
//            System.out.println(pro);
//        } catch (IOException e) {
//            throw new RuntimeException("文件读取异常");
//        } finally {
//            try {
//                fis.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        try {
            getPro(pro,file);
            System.out.println(pro);
            ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //    读取本地配置文件，并将读取的数据存入到Propertied对象中,相当于重新实现load()方法
    public static void getPro(Properties pro, File file) throws IOException {
        BufferedReader bufr = new BufferedReader(new FileReader("info.init"));
        String line=null;
        while ((line = bufr.readLine()) != null) {
            String[] split = line.split("=");
            //将截取出来的字符串存入properties对象
            pro.setProperty(split[0], split[1]);

        }
        bufr.close();
        System.out.println(pro);

    }


}
