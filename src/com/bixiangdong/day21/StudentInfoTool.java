package com.bixiangdong.day21;

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

/*
1. 实现键盘录入，并将数据存储到treeset中。treeset getStudent()
 */
public class StudentInfoTool {

    public static TreeSet<Student> getStudent() throws IOException {
        return getStudent(null);
    }
    public static TreeSet<Student> getStudent(Comparator<Student> cmp) throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Student> stuSet =null;
        if (cmp == null) {
            stuSet = new TreeSet<>();
        }else
            stuSet = new TreeSet<>(cmp);

        String line;
        while ((line = bufr.readLine()) != null) {
            if (line.equals("over"))
                break;
            String[] split = line.split(",");
            stuSet.add(new Student(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3])));
        }
        bufr.close();
        return stuSet;
    }

    public static void writeToFile(TreeSet<Student> ts) throws IOException {
        BufferedWriter bufw = new BufferedWriter(new FileWriter("stu.txt"));
        for (Student stu : ts) {
            bufw.write(stu.toString());
            bufw.newLine();
            bufw.flush();
        }
        bufw.close();
    }
}
