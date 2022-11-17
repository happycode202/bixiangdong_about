package com.bixiangdong.day15;
/*

*## Set:无序，不可重复

- HashSet
  - 数据结构是哈希表，线程间是非同步的。
  - 保证元素唯一性的原理：判断元素的hashCode值是否相同如果相同，还会继续调用元素的equals方法，判断是否为true
- TreeSet
  - 可以对Set集合中的元素进行排序。排序是实现了comparable接口
  - 排序时，当主要条件相同时，一定判断一下次要条件。
*/

import java.util.Iterator;
import java.util.TreeSet;

//* 需求：
//* 往TreeSet集合中存储自定义的学生对象，想按照学生的年龄进行排序
public class TreeSetDemo2 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new Student("lisi01", 10));
        ts.add(new Student("lisi02", 20));
        ts.add(new Student("lisi03", 30));
        ts.add(new Student("lisi03", 30));
        ts.add(new Student("lisi04", 40));
        ts.add(new Student("lisi04", 40));

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            Student stu = (Student) it.next();
            System.out.println(stu.getName() + "……" + stu.getAge());
        }
    }
}

class Student implements Comparable {
    private int age;
    private String name;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 因为需求是根据年龄排序，年龄相同是按照名字的字典顺序排序
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Student)) {
            throw new RuntimeException("不是学生类");
        }
        Student stu = (Student) o;
        if (this.age == stu.getAge()) {
            //如果名字相同返回0
            return this.name.compareTo(stu.getName());
        }
        return this.age > stu.getAge() ? 1 : -1;
    }
}