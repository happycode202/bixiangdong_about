package com.bixiangdong.day14;

import java.util.HashSet;
import java.util.Iterator;

/*
* |--Set: 元素是无序（存入和取出的顺序不一定一致），元素不可以重复
*       |--HashSet:底层数据结构是哈希表
*               HashSet是如何暴政元素的唯一性呢？
*                   是通过元素的两个方法，hashCode和equals来完成
*                   如果元素的HashCode相同，才会判断equals是否为true
*                   如果元素的HashCode不同，不会调用equals
*
*                   注意，对于判断元素是否存在，以及删除等操作，依赖的方法是元素的hashcode和equals方法
*
*       |--TreeSet:
* Set集合的功能和Collection的功能是一致的
*
*
* 往hashset集合中存入自定义对象
* 姓名和年龄相同的为同一个人
*
*
* */
class Person1{
    private int age;
    private String name;
    Person1(String name,int age){
        this.name=name;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int hashCode(){
        return name.hashCode()+age*39;//根据实际情况自定义
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Person1)) {
            return false;
        }
        Person1 p = (Person1)obj;
        return this.age == p.getAge() && this.name.equals(p.getName());
    }
}
public class HashSetDemo {
    public static void main(String[] args) {
        //无序行+唯一性
//        method_1();
        HashSet hs = new HashSet();
        hs.add(new Person1("lisi01", 10));
        hs.add(new Person1("lisi02", 20));
        hs.add(new Person1("lisi03", 30));
        hs.add(new Person1("lisi04", 40));
        hs.add(new Person1("lisi03", 30));
        hs.add(new Person1("lisi04", 40));

        Iterator it = hs.iterator();
        while (it.hasNext()) {
            Person1 p = (Person1)it.next();
            System.out.println(p.getName()+"……" + p.getAge());
        }

        System.out.println(hs);

    }

    private static void method_1() {
        HashSet hs = new HashSet();
        hs.add("java01");
        hs.add("java02");
        hs.add("java03");
        hs.add("java04");
        hs.add("java05");

        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
