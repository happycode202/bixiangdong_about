package com.bixiangdong.day21;

import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    public int age;

    Person(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public String toString(){
        return name+":" +age;
    }
}
