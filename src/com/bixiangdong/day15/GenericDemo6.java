package com.bixiangdong.day15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ？通配符：可以理解为占位符
 * 泛型的限定：
 *  ？ extends E:可以接收E类型或者E的子类型，上限
 *  ？ super E：可以接收E类型或者E的父类，下限
 */
public class GenericDemo6 {
    public static void main(String[] args) {
        ArrayList<Person> a1 = new ArrayList<>();
        a1.add(new Person("zhngsan03"));
        a1.add(new Person("zhngsan01"));
        a1.add(new Person("zhngsan02"));

        ArrayList<Student2> a2 = new ArrayList<>();
        a2.add(new Student2("lisi02"));
        a2.add(new Student2("lisi03"));
        a2.add(new Student2("lisi01"));

        printColl(a1);
        printColl(a2);
    }

    public static void printColl(Collection<? extends Person> al) {
        Iterator<? extends Person> it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
    }
}
