package com.bixiangdong.day18;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 两个练习：
 * 1. 获取任意年的二月有多少天
 * 2. 获取昨天的现在这个时刻
 */
public class CalendarDemo2 {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int inputNum = input.nextInt();
//        System.out.println(inputNum);
        //每年的2月有多少天，可以先确定每年的3.1号，日期-1获得的day_of_month就是2月的天数
        Calendar c = Calendar.getInstance();
//        c.clear();
        c.set(2022, 2, 1);
        System.out.println(c.get(Calendar.YEAR));//calendar类中，被finale修饰的常量 YEAR,MONTH,DAY_OF_MONTH,是fileds【】数组的index，set(int year,int month,int day)方法将传入的值存储在fileds[]中。
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));

        c.set(2022, 2, 10);

        System.out.println("______");
        c.add(c.DAY_OF_MONTH,-1);
          System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }
}
