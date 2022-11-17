package com.bixiangdong.day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
- TreeSet第二种排序方式。当元素自身不具备比较性时，或者具备的比较性不是所需要的，这是需要让集合自身具有比较性。在集合初始化时，就有了比较方式。
- 当两种排序方式都存在时，以比较器为主。
- 定义一个类，实现Comparator接口，覆盖compare方法。
* */
public class TreeSetDemo3 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet(new MyCompare());
        ts.add(new Student1("lisi01", 10));
        ts.add(new Student1("lisi02", 20));
        ts.add(new Student1("lisi03", 30));
        ts.add(new Student1("lisi03", 30));
        ts.add(new Student1("lisi04", 40));
        ts.add(new Student1("lisi04", 40));

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            Student1 stu = (Student1) it.next();
            System.out.println(stu.getName() + "……" + stu.getAge());
        }


    }
}

class MyCompare implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student1 s1 = (Student1)o1;
        Student1 s2 = (Student1)o2;
        //名相同，比较年龄
        if (s1.getName().equals(s2.getName())) {
            return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));//compareTo返回的值 正 0 负，和return需要返回的值是一致的。
        }
        //名字不同的直接比较
        return s1.getName().compareTo(s2.getName());
    }
}
class Student1 implements Comparable{
    private int age;
    private String name;

    public Student1(String name, int age) {
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
        if (!(o instanceof Student1)) {
            throw new RuntimeException("不是学生类");
        }
        Student1 stu = (Student1) o;
        if (this.age == stu.getAge()) {
            //如果名字相同返回0
            return this.name.compareTo(stu.getName());
        }
        return this.age > stu.getAge() ? 1 : -1;
    }
}


