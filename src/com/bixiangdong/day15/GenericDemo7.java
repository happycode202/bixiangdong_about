package com.bixiangdong.day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo7 {
    public static void main(String[] args) {
        TreeSet<Student2> ts = new TreeSet<Student2>(new Comp());
        ts.add(new Student2("adc3"));
        ts.add(new Student2("adc2"));
        ts.add(new Student2("adc1"));

        Iterator<Student2> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
        TreeSet<Worker> ts1 = new TreeSet<Worker>(new Comp());
        ts1.add(new Worker("adc33"));
        ts1.add(new Worker("adc23"));
        ts1.add(new Worker("adc14"));

        Iterator<Worker> it1 = ts1.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next().getName());
        }

    }
}

//比较器
class Comp implements Comparator<Person> {
    public int compare(Person s1, Person s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student2 extends Person {
    Student2(String name) {
        super(name);
    }
}

class Worker extends Person {
    Worker(String name) {
        super(name);
    }
}