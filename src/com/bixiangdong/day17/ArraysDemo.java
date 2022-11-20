package com.bixiangdong.day17;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//ArraysDemo
//asList:讲述组变成list集合
public class ArraysDemo {
    public static void main(String[] args) {
//        int[] arr = {1, 4, 6};
        String[] str = {"adb", "b", "adbc", "zzzz"};
//        System.out.println(arr);
//        System.out.println(Arrays.toString(arr));
//        List<String> list = Arrays.asList(str);
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);

        //把数组变成list集合的好处？
//      可以使用集合的思想和方法来操作数组中的元素
        List<String> list = Arrays.asList(str);
        System.out.println("list.contains:" + list.contains("b"));

        /*
        如果数组中的元素都是对象，那么变成集合时，数组中的元素就直接转成集合中的元素。
        如果数组中的元素都是基本数据类型，那么会将该数组作为集合中一个元素存在。
        * */
        int[] nums = {2, 3, 5};
        List<int[]> li = Arrays.asList(nums);//基本数据类型的数组被当作一个元素存储在list集合中。数据类型为引用数据类型：int[]

        System.out.println(li);

        Integer[] integers = {2, 3, 5};
        List<Integer> liInteger = Arrays.asList(integers);//数组中的基本数据类型会自动装箱为引用数据类型，每个元素都会被单独存储为集合中的一个元素，数据类型为原来的Integer
        System.out.println(liInteger);



    }

    public static boolean myContains(String[] arr, String key) {
        for (int x = 0; x < arr.length - 1; x++) {
            if (arr[x].equals(key)) {
               return true;
            }
        }
        return false;
    }
}
