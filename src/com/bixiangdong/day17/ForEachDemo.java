package com.bixiangdong.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *高级for循环
 *
 * jdk1.2-1.4 Iterator  jdk1.5 Iterable
 * 格式：for（数据类型 变量名：被遍历的集合（Collection）或数组）{}
 * 简化书写，但不能对集合中的元素进行额外操作。
 * 对集合遍历，只能获取元素，但不能对集合进行操作。
 * 迭代器除了遍历，还可以进行remove的操作，Arraylist
 * 如果使用ListIterator，还可以在遍历过程中进行增删改查的操作。
 *
 * 传统for循环和高级for区别？
 * 高级for有局限性，必须有被遍历的目标。
 *
 * 建议在遍历数组的时候使用传统for，
 */
public class ForEachDemo {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();
//
//        int[] arr = {1, 3, 5};
//        for (int i :
//                arr) {
//            System.out.println(i);
//        }
//        method_forEach();
        //map集合使用高级for遍历集合中的元素
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "adb");
        hm.put(2, "db");
        hm.put(0, "b");

//        method_hm_foreach(hm);
        Set<Map.Entry<Integer, String>> entrySet = hm.entrySet();
        for (Map.Entry<Integer, String> me :
                entrySet) {
            System.out.println(me.getKey()+"……"+me.getValue());
        }
    }

    private static void method_hm_foreach(HashMap<Integer, String> hm) {
        Set<Integer> keyset = hm.keySet();
        for (Integer num :
                keyset) {
            System.out.println(num + "^^^" + hm.get(num));
        }
    }

    private static void method_forEach() {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(3);
        al.add(4);
        al.add(1);
        for (Integer integer:
             al) {
            System.out.println(integer);
        }
    }
}
