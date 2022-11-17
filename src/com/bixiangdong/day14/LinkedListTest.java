package com.bixiangdong.day14;

/*
使用 LinkedList模拟一个堆栈或者队列数据结构

堆栈:先进后出 如同一个杯子
队列:先进先出 如同一个水管
*/

import java.util.LinkedList;

class Queue{
    private LinkedList link;
    Queue(){
        link = new LinkedList();
    }

    public void myAdd(Object obj) {
        link.addLast(obj);
    }

    public Object myGet(){
        return link.removeFirst();
    }

    public boolean isNull(){
        return link.isEmpty();
    }



}
public class LinkedListTest {
    public static void main(String[] args) {
        //使用自己封装的队列结构方法
        Queue q = new Queue();
        q.myAdd("java01");
        q.myAdd("java02");
        q.myAdd("java03");

        while (!q.isNull()) {
            System.out.println(q.myGet());
        }

    }
}
