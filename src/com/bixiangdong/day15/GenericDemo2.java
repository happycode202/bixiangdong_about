package com.bixiangdong.day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**按照字母长度排序,相同长度的字符按字母的自然顺序排序
 *
 */
public class GenericDemo2 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>(new LenthComparator());
        ts.add("adcd");
        ts.add("abcde");
        ts.add("abc");
        ts.add("ade");

        Iterator<String> it = ts.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }

}

/**
 * 自定义比较类
 */
class LenthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int num = new Integer(o1.length()).compareTo(new Integer(o2.length()));
        if (num == 0) {
            return o1.compareTo(o2);
        }

        return num;
    }
}