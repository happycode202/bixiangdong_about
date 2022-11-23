package com.bixiangdong.day18;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
//        method_1();
        Calendar c = Calendar.getInstance();
        /**/
        method_2(c);
        //大写的星期月份
        String[] mons = {"一月", "二月", "三月", "四月"
                , "五月", "六月", "七月", "八月"
                , "九月", "十月", "十一月", "十二月"};
        String[] weeks = {
                "", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六",};
        int y = c.YEAR;
        int m = c.get(Calendar.MONTH);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int week = c.get(Calendar.DAY_OF_WEEK);

        System.out.println(y + "年" + mons[m]  + d + "日" + weeks[week]);

    }

    private static void method_2(Calendar c) {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "年" + (month + 1) + "月" + day + "日");
    }

    private static void method_1() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
    }
}
