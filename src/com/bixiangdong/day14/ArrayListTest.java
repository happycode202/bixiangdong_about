package com.bixiangdong.day14;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;

/*
去除 ArrayList 中的重复元素
*/
public class ArrayListTest {
    public static void main(String[] args) {

    }

    public static ArrayList singleElement(ArrayList list) {
        //定义一个临时容器
        ArrayList nl = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (!nl.contains(obj)) {
                nl.add(obj);
            }
        }
        return nl;
    }
}
