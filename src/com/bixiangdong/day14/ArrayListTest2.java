package com.bixiangdong.day14;
/*
 * 将自定义对象作为元素存储到ArrayList集合中，并去除重复元素
 * 比如：存人对象，同姓名同年龄，视位同一个人。为重复元素
 *
 *思路：
 * 1. 对人描述，将数据封装进人对象
 * 2. 定义容器，将人存入。
 * 3. 取出
 *
 *
 * List集合元素判断元素是否相同，依据是元素的equals方法。
 *
 * 这个事情的本质是多态造成的。ArrayList在实现contains（）方法的时候，底层采用的是equals()方法。代码如下：
 *      indexOf(Object o) 方法中，传入的o，本质是Object o= Person p;这是多态，父类引用指向子类对象，
 *      他的非静态方法，在编译时是与父类一致的，运行时却与子类一致（发生了复写）。
 *
 * *     public boolean contains(Object o) {
 *        return indexOf(o) >= 0;
 *    }
 *
 *     * Returns the index of the first occurrence of the specified element
 *     * in this list, or -1 if this list does not contain the element.
 *     * More formally, returns the lowest index <tt>i</tt> such that
 *     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
 *     * or -1 if there is no such index.
 *      public int indexOf(Object o) {
 *        if (o == null) {
 *        for (int i = 0; i < size; i++)
 *        if (elementData[i]==null)
 *        return i;
 *        } else {
 *        for (int i = 0; i < size; i++)
 *        if (o.equals(elementData[i]))
 *        return i;
 *        }
 *        return -1;
 *        }
 *
 */

import java.util.ArrayList;
import java.util.Iterator;

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return this.name.equals(person.name) && this.age == person.age;
    }
}

public class ArrayListTest2 {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(new Person("lisi01", 30));
        al.add(new Person("lisi02", 40));
        al.add(new Person("lisi03", 50));
        al.add(new Person("lisi04", 60));
        al.add(new Person("lisi01", 30));
        al.add(new Person("lisi02", 40));
        al.add(new Person("lisi01", 30));
        al.add(new Person("lisi02", 40));

        al = singleElement(al);
        Iterator it = al.iterator();
        while (it.hasNext()) {
            Person p = (Person) it.next();
            System.out.println(p.getName() + "……" + p.getAge());
        }
    }

    public static ArrayList singleElement(ArrayList list) {
        //定义一个临时容器
        ArrayList newAl = new ArrayList();

        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (!newAl.contains(obj)) {
                newAl.add(obj);
            }
        }
        return newAl;
    }
}

class Fu {

    int num = 5;

    static void method4() {

        System.out.println("fu method_4");

    }

    void method3() {

        System.out.println("fu method_3");

    }

}
