package com.bixiangdong.day14;

import java.util.LinkedList;

/*
LinkedList:特有方法:
addFirst();
addLast();

getFirst();
getLast()
获取元素,但不删除元素,如果集合中没有元素,会出现 NoSuchElementException

removeFirst();
removeLast();
获取元素并删除元素,如果集合中没有元素会出现 NoSuchElementException

再 jdk1.6 中出现了替代方法

offerFirst();
offerLast();

peekFirst();
PeekLast();
获取元素,但不删除元素,如果集合中没有元素,会返回 null

pollFirst();
PollLast();
获取元素,但元素会被删除,如果集合中没有元素,会返回 null
*/
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList link = new LinkedList();
        link.addFirst("java01");
        link.addFirst("java02");
        link.addFirst("java03");

        while (!link.isEmpty()) {
            System.out.println(link.removeFirst());
        }
//        System.out.println(link);
    }
}
