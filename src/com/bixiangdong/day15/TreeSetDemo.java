package com.bixiangdong.day15;

import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.TreeSet;

/*
*
* */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("cba");
        ts.add("abcd");
        ts.add("aaa");
        ts.add("bca");

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
