package com.bixiangdong.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
*
/*
集合框架的工具类。
Collections:集合框架的工具类。里面定义的都是静态方法。

Collections和Collection有什么区别？
Collection是集合框架中的一个顶层接口，它里面定义了单列集合的共性方法。
		它有两个常用的子接口，
		List：对元素都有定义索引。有序的。可以重复元素。
		Set：不可以重复元素。无序。

Collections是集合框架中的一个工具类。该类中的方法都是静态的
		提供的方法中有可以对list集合进行排序，二分查找等方法。
		通常常用的集合都是线程不安全的。因为要提高效率。
		如果多线程操作这些集合时，可以通过该工具类中的同步方法，将线程不安全的集合，转换成安全的。
* */
public class CollectionsDemo {
    public static void main(String[] args) {
        binarySearchDemo();
    }

//    获取最大值


    //binarySearchDemo 二分法查找 二分查找需要数据有序，只有有序的数据才能不断的折半，变化最大最小值

    public static void binarySearchDemo() {
        List<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("aaa");
        list.add("zz");
        list.add("kkkkk");
        list.add("qq");
        list.add("z");
        Collections.sort(list,new StrLenComparator());
        System.out.println(list);
        System.out.println(halfSearch2(list,"aaa",new StrLenComparator()));
//        System.out.println(halfSearch(list, "b"));;
//        System.out.println(list);
//        System.out.println(Collections.binarySearch(list, "kkkkk"));
    }
        //查询有序数组内，key值对应的索引
    public static int halfSearch(List<String> list,String key) {
        //二分查找 min mid max 如果mid>=max 查找结束
        int max, min, mid;
        min = 0;
        max = list.size() - 1;
        while (min <= max) {
            mid = (min + max) >> 1;
            int num = list.get(mid).compareTo(key);
            if (num > 0) {
                max = mid-1;
            } else if (num < 0) {
                min = mid+1;
            }else {
                return mid;
            }
        }
        return -min-1;
    }

    //根据值，获取索引，二分法 比较方法指定为Comparator
//    按照字符串的长度排序，如果长度相同，按照字母的自然顺序排列
    public static int halfSearch2(List<String> list, String value, Comparator<String> comp) {
        int min, mid, max;
        min = 0;
        max = list.size()-1;
        while (min <= max) {
            mid = (min+max)>>1;
            int num = comp.compare(list.get(mid),value);
            if (num == 0) {
                return mid;
            } else if (num < 0) {
                min = mid+1;
            }else {
                max = mid-1;
            }
        }


        return -min-1;
    }
}

class StrLenComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        int num = Integer.compare(s1.length(), s2.length());
        if (num == 0) {
            return s1.compareTo(s2);
        }
        return num;
    }
}


