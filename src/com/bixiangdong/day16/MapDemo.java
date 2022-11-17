package com.bixiangdong.day16;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("01", "zhangsan01");
        map.put("03", "zhangsan03");
        map.put("02", "zhangsan02");
        System.out.println("map.containsKey:"+ map.containsKey("01"));
        System.out.println("get:" + map.get("02"));
        System.out.println(map);
    }
}
