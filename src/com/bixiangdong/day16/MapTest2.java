package com.bixiangdong.day16;

import java.lang.management.ManagementFactory;
import java.util.*;

/*
需求：对学生对象的年龄进行升序排序。(学生对象和上一个例子的要求相同，并按照年龄升序排列，如果名字相同，按照名字的自然顺序排列）

因为数据是以键值对形式存在的。
所以要使用可以排序的Map集合。TreeMap。
*/
public class MapTest2 {
    public static void main(String[] args) {
        TreeMap<Student1,String> tm = new TreeMap<>(new Stucomp());
//        tm.put(new Student1("lisi1", 1),"beijing");
//        tm.put(new Student1("lisi002", 3),"shanghai");
//        tm.put(new Student1("lisi01", 2),"tianjin");

        tm.put(new Student1("blisi3",23),"nanjing");
        tm.put(new Student1("lisi1",21),"beijing");
        tm.put(new Student1("alisi4",24),"wuhan");
        tm.put(new Student1("lisi1",21),"tianjin");
        tm.put(new Student1("lisi2",22),"shanghai");

        Set<Map.Entry<Student1,String>> entrySet = tm.entrySet();
        Iterator<Map.Entry<Student1,String>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<Student1, String> me = it.next();
            Student1 key = me.getKey();
            String value = me.getValue();
            System.out.println(key + "……" + value);
        }

    }
}
//按照名字的自然顺序排
class Stucomp implements Comparator<Student1> {
    public int compare(Student1 s1, Student1 s2) {
        int num = s1.getName().compareTo(s2.getName());
        if (num == 0) {
            return Integer.compare(s1.getAge(), s2.getAge());
        }
        return num;
    }
}
