package com.bixiangdong.day16;

import javax.lang.model.element.NestingKind;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
每一个学生都有对应的归属地。
学生Student，地址String。
学生属性：姓名，年龄。
注意：姓名和年龄相同的视为同一个学生。
保证学生的唯一性。



1，描述学生。

2，定义map容器。将学生作为键，地址作为值。存入。

3，获取map集合中的元素。

*/
public class MapTest {
    public static void main(String[] args) {
        HashMap<Student, String> hm = new HashMap<>();
        hm.put(new Student("lisi01", 11), "beijing");
        hm.put(new Student("lisi01", 11), "hanghai");
        hm.put(new Student("lisi03", 30), "tianjin");

        //两种取出方法 keyset方法
        Set<Student> keySet = hm.keySet();
        Iterator<Student> it = keySet.iterator();
        while (it.hasNext()) {
            Student key = it.next();
            String value = hm.get(key);
            System.out.println(key + "^^^" +value);
        }
    }
}

class Student implements Comparable<Student>{
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //可能会被存储到以哈希表数据结构为底层的工具类中，所以需要重写hashcode equals
    public int hashCode() {
        return name.hashCode() + age * 39;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            throw new ClassCastException("类型不匹配");
        }
        Student stu = (Student) obj;
        return this.name.equals(stu.getName()) && this.age == stu.getAge();
    }

    @Override
    public int compareTo(Student o) {
//        int num = new Integer(this.age).compareTo(new Integer(o.getAge()));
        int num = Integer.compare(this.age, o.getAge());
        if (num == 0) {
            return this.name.compareTo(o.getName());
        }
        return num;
    }

    public String toString() {
        return name + "……" + age;
    }
}