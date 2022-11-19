package com.bixiangdong.day17;

import java.util.*;

/*
练习：
    fill方法可以将list集合中所有元素替换成指定元素
    2.将list集合中的部分元素替换成指定元素


    静态方法只能访问静态内部类，

* */
public class CollectionsDemo2 {
    public static void main(String[] args) {
        TreeSet<String> list = new TreeSet<>(Collections.reverseOrder(new StrLenComparator2()));

        list.add("abj");
        list.add("d");
        list.add("df");
        list.add("iindl");

//        Collections.sort(list);
        System.out.println(list);
    }
}

class StrLenComparator2 implements Comparator<String> {
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}