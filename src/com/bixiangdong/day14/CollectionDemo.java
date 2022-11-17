package com.bixiangdong.day14;
import sun.font.FontRunIterator;

import java.util.*;
public class CollectionDemo {

    public static void main(String[] args) {
        //method_1();
        method_get();

    }
    public static void method_get(){
        ArrayList list1 = new ArrayList();
        list1.add("java01");
        list1.add("java02");
        list1.add("java03");
        list1.add("java04");

        Iterator it = list1.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //多用下面方法,变量的生命周期比较短,随着方法执行结束,对象的生命周期也结束
        for (Iterator it1 = list1.iterator(); it1.hasNext(); ) {
            System.out.println(it1.next());
        }
    }

    private static void method_1() {
        ArrayList list1 = new ArrayList();
        list1.add("java01");
        list1.add("java02");
        list1.add("java03");
        list1.add("java04");

        ArrayList list2 = new ArrayList();

        list2.add("java01");
        list2.add("java02");
        list2.add("java05");
        list2.add("java06");

        list1.retainAll(list2);//list1中保留和 list2 中相同的部分
        //list1.removeAll(list2);//list1保留和list2中不同的部分
        System.out.println(list1);
        System.out.println(list1.size());
        //print list1
        System.out.println(list1);
        //remove
        list1.remove("java01");
        System.out.println(list1);
        //is contains java01
        Boolean isContains = list1.contains("java01");
        System.out.println("list1 包含 java01 吗" + isContains);
        System.out.println("List是空集合吗?"+list1.isEmpty());

        //print changed list1
        System.out.println(list1);
    }
}
