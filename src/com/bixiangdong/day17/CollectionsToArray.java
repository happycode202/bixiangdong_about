package com.bixiangdong.day17;


import java.util.ArrayList;
import java.util.Arrays;

public class CollectionsToArray {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("adc1");
        al.add("adc2");
        al.add("adc3");

        		/*
		1,指定类型的数组到底要定义多长呢？
		当指定类型的数组长度小于了集合的size，那么该方法内部会创建一个新的数组。长度为集合的size。
		当指定类型的数组长度大于了集合的size，就不会新创建了数组。而是使用传递进来的数组。
		所以创建一个刚刚好的数组最优。


		2,为什么要将集合变数组？
		为了限定对元素的操作。不需要进行增删了。

		3.集合变数组：Collection中的toArray(T[] a)方法
		数组变集合：Arrays中的asList方法
		*/
        String[] arr = al.toArray(new String[al.size()]);
        System.out.println(Arrays.toString(arr));
    }
}
