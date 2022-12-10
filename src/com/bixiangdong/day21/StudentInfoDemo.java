package com.bixiangdong.day21;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/*
1. 定义一个学生类，name math cn en
                如：zhagnsan，30，40，60
2. 定义一个可操作学生对象的工具类
 键盘录入数据并将数据存储到student中，
 将多个student实例存储到集合中。因为需要排序，使用treeset集合
 看看实现的Comparable中的方法，是否满足需求，不满足需要使用比较器。
 将集合中的数据存储到stud.txt中。

方法1:
1. 实现键盘录入，并将数据存储到treeset中。void getData()
2. 将集合中的数据存储到本地文件。
 */
public class StudentInfoDemo {
    public static void main(String[] args) throws IOException {
        Comparator<Student> cmp = Collections.reverseOrder();
        TreeSet<Student> stu = StudentInfoTool.getStudent(cmp);
        //将数据写入到文件中
        StudentInfoTool.writeToFile(stu);

    }
}

