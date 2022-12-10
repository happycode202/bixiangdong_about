package com.bixiangdong.day21;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name ;
     private int cn,en,math;
     private int sum;

    Student(String name, int cn, int en, int math) {
        this.name=name;
        this.cn=cn;
        this.en=en;
        this.math=math;
        sum = cn + en + math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCn() {
        return cn;
    }

    public void setCn(int cn) {
        this.cn = cn;
    }

    public int getEn() {
        return en;
    }

    public void setEn(int en) {
        this.en = en;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return getCn() == student.getCn() && getEn() == student.getEn() && getMath() == student.getMath() && getSum() == student.getSum() && getName().equals(student.getName());
//    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            throw new ClassCastException("类型转换异常");
        }
        Student stu=(Student) obj;
        return this.name.equals(stu.getName()) && this.sum==stu.getSum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCn(), getEn(), getMath(), getSum());
    }

    @Override
    public int compareTo(Student o) {
        int num = new Integer(this.sum).compareTo(new Integer(o.getSum()));
        if (num == 0) {
            return this.name.compareTo(o.getName());
        }
        return num;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cn=" + cn +
                ", en=" + en +
                ", math=" + math +
                ", sum=" + sum +
                '}';
    }
}
