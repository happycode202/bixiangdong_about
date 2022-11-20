package com.bixiangdong.day18;

import java.util.Properties;

/**
 * System:
 *
 * out:标准输出，默认是控制台
 * in：标准输入，默认是键盘
 *
 * 系统描述信息
 * 获取系统属性信息：Properties getProperties();
 *
 */
public class SystemDemo {
    public static void main(String[] args) {
        Properties prop = System.getProperties();

        System.setProperty("mykey", "myvalue");
        //因为Properties是Hashtable的子类，也就是Map集合的子类对象，那么可以通过map集合的方法取出该集合中的元素
        for (Object obj : prop.keySet()) {
            System.out.println(obj+"______" +prop.get(obj));
        }

        System.out.println(System.getProperty("mykey"));

    }
}
