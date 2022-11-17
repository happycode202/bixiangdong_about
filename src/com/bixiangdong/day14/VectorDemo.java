package com.bixiangdong.day14;

import java.util.Enumeration;
import java.util.Vector;

/*
* 枚举就是 Vector 特有的取出方式
* 枚举和迭代器很像,
* 枚举和迭代器时一样的
*
* 为什么搞出来个 Iterator
* 因为枚举的名称以及方法的名称过长
* 所以被迭代器取代了
*
* */
public class VectorDemo {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("java01");
        v.add("java02");
        v.add("java03");

        Enumeration e = v.elements();

        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

    }


}
