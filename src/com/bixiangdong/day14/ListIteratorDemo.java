package com.bixiangdong.day14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        //使用 listIterator 遍历修改集合内容
        ArrayList list1 = new ArrayList();
        list1.add("java01");
        list1.add("java02");
        list1.add("java03");

//        method_1(list1);
        //使用listIterator遍历集合
        ListIterator li = list1.listIterator();
        while (li.hasNext()) {
            Object obj = li.next();
            if (obj.equals("java02")) {
                li.set("java0000");
            }
        }
        System.out.println(list1);
    }

    private static void method_1(ArrayList list1) {
        //遍历集合内容
        //Iterator it = list1.iterator();
        for (Iterator it = list1.iterator(); it.hasNext(); ) {
            Object obj = it.next();
            if (obj.equals("java02")) {
               // list1.add("java00000");//并发修改异常
                it.remove();
            }
        }
        System.out.println(list1);
    }
}
