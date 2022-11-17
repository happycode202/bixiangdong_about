package com.bixiangdong.day16;

import java.util.*;

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
public class MapTestn {
    public static void main(String[] args) {
        HashMap<Student1, String> hm = new HashMap<Student1, String>();
        hm.put(new Student1("lisi1", 1),"beijing");
        hm.put(new Student1("lisi002", 3),"shanghai");
        hm.put(new Student1("lisi01", 2),"tianjin");

//        method_1(hm);
        method_2(hm);
    }

    private static void method_2(HashMap<Student1, String> hm) {
        //Map.Entry<k,v>
        Set<Map.Entry<Student1, String>> entrySet = hm.entrySet();
        Iterator<Map.Entry<Student1, String>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<Student1, String> me = it.next();
            Student1 key = me.getKey();
            String value = me.getValue();
            System.out.println(key + "^" +value);
        }
    }

    private static void method_1(HashMap<Student1, String> hm) {
        //取出hashmap的每一项keySet方法
        Set<Student1> keySet = hm.keySet();
        Iterator<Student1> it = keySet.iterator();
        while (it.hasNext()) {
            Student1 key = it.next();
            String value = hm.get(key);
            System.out.println(key+"^" + value);
        }
    }
}

class Student1Comp implements Comparator<Student1> {

    @Override
    public int compare(Student1 o1, Student1 o2) {
        int num = Integer.compare(o1.getAge(), o2.getAge());
        if (num == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return num;
    }
}
class Student1 implements Comparable<Student1> {
    private String name;
    private int age;

    Student1(String name, int age) {
        this.name=name;
        this.age=age;
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

    //因为使用hashmap集合，底层要调用hashcode方法和equals方法来判断是否相同。所以要重写这两个方法。
    @Override
    public boolean equals(Object obj) {
        if (!((obj instanceof Student1))) {
            throw new ClassCastException("类型转换异常");
        }
        Student1 stu = (Student1) obj;
        return this.name.equals(stu.getName()) && this.age == stu.getAge();
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+age*39;
    }

    @Override
    public int compareTo(Student1 o) {
        int num = Integer.compare(this.age, o.getAge());
        if (num ==0)
            return this.name.compareTo(o.getName());
        return num;
    }

    @Override
    public String toString() {
        return name +"……" + age;
    }

}