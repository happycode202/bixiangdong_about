package com.bixiangdong.day15;

import java.util.ArrayList;
import java.util.Iterator;

/**泛型基本练习
 *
 */
public class GenericDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("adb");
        list.add("adbc");
        list.add("adbcd");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
//            System.out.println(it.next());
            String s = it.next();//上面的泛型约束下，不需要强制类型转换

        }

    }
}
