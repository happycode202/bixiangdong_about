package com.bixiangdong.day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 练习：按照字符串的长度排序
 *
 * 字符串本身具备比较性，但是他的比较性不是我们需要的
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet(new StringLengthComparator());
        ts.add("adb");
        ts.add("bbs");
        ts.add("bdsd");
        ts.add("cdbjd");
        ts.add("adc");

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class StringLengthComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;
//        //如果字符串长度相同，按照字符串的字母顺序排序
//        if (s1.length() == s2.length()) {
//            return s1.compareTo(s2);
//            //如果字符串长度不同，直接比较
//        }
//        return new Integer(s1.length()).compareTo(new Integer(s2.length()));
        int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
        if (num == 0) {
            return s1.compareTo(s2);
        }
        return num;
    }

}