package com.bixiangdong.day14;
/*
Collection
   | -- list:元素是有序的,元素是可以重复的,因为该集合体系有索引
        |--ArrayList:底层数据结构使用的是数组数据结构 特点:查找很快,增删稍慢,线程不同步
        |--LinkedList:底层使用的是链表数据结构 特点:查询稍慢,增删很快
        |--Vector:底层是数组数据结构 线程同步 被 Arraylist 取代


   | -- set :元素是无序的,元素不可以重复

List:
    特有方法,反噬可以操作角标的方法都是该体系特有的方法

    增
        add(index,element);
        addAll(intex,Collection);

    删
        remove(index);
    改
        set(index,element);
    查
        get(index);
        subList(form,to);
        listIterator

List集合特有的迭代器,ListIterator 是 Iterator的子接口
在迭代时,不可以通过集合对象的方法操作集合中的元素,因为会发生 ConcurrentModificationException异常

所以,再迭代时,只能使用迭代器的方法操作元素,可是 Iterator 方法是有限的,
只能对元素进行判断,取出,删除的操作,
如果想要其他的操作如添加,修改等,就需要使用其子接口,ListIterator.
该接口只能通过List 集合的 ListIterator方法获取.
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();

        //添加元素
        list1.add("java01");
        list1.add("java02");
        list1.add("java03");

        System.out.println(list1);
        //method_1(list1);

        //使用 ListIterator
        ListIterator li = list1.listIterator();
        while (li.hasNext()) {
            Object obj = li.next();
            if (obj.equals("java02")) {
                li.set("java00000");
            }
        }
        System.out.println(list1);

        while (li.hasPrevious()) {
            Object pre = li.previous();
            if (pre.equals("java00000")) {
                li.set("java02");
            }
        }
        System.out.println(list1);

    }

    private static void method_1(ArrayList list1) {
        System.out.println("原集合是"+ list1);
        //指定位置添加元素
        list1.add(1, "java09");
        System.out.println(list1);

        //删除指定位置元素
        list1.remove(2);
        System.out.println(list1);

        //修改指定位置元素
        list1.set(1, "java10");
        System.out.println(list1);

        //通过角标获取元素
        list1.get(1);
        System.out.println(list1.get(1));

        //获取所有元素
        for (Iterator it = list1.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }
}
