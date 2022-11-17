package com.bixiangdong.day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * map集合的两种取出方式：
 * 1. keySet：将map中所有的键存入到Set集合，因为set具备迭代器，可以用迭代器的方式取出所有的键，再根据get方法，获取每一个键对应的值。
 * - Map集合的取出原理：将map集合转换为set集合，再通过迭代器取出
 * 2. Set<Map.Entry<K,V>> entrySet: 将map集合中的映射关系存入到set集合中，而这个关系就是Map.Entry<k.v>
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("01", "zhangsan01");
        map.put("03", "zhangsan03");
        map.put("02", "zhangsan02");

//        method_keySet(map);
        //用entrySet方法获取键值
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String,String>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> me = it.next();
            String key = me.getKey();
            String value = me.getValue();
            System.out.println("key=" + key + ",value=" + value);
        }
    }

    private static void method_keySet(Map<String, String> map) {
        //获取所有的key value
        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = map.get(key);
            System.out.println("key: " + key + ",value:" + value);
        }
    }

}
