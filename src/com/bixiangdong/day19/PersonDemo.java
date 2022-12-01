package com.bixiangdong.day19;


/*
装饰设计模式
当想要对已有的对象进行功能增强时，
那么定义类，将已有的对象传入，基于已有的功能，并提供增强功能
那么自定义的该类称为装饰类

装饰类通畅会通过构造方法接收被装饰的对象
并基于被装饰对象的功能，提供更强的功能
 */
public class PersonDemo {

}

class Person {
    public void chiFan() {
        System.out.println("吃饭");
    }
}
class SuperPerson{
    private Person p;
    SuperPerson(Person p) {
        this.p = p;
    }
    public void superChiFan() {
        p.chiFan();
        System.out.println("哈啤酒");

    }
}