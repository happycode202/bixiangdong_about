package com.bixiangdong.day17;

/**
 * jdk1.5出现的新特性
 * <p>
 * 虽然少定义了多个方法，但每次都要定义一个数组作为实际参数
 * <p>
 * 可变参数：
 * 其实就是上矣中数组参数的简写形式，不用每一次都手动建立数组对象
 * 只要将需要操作的数据作为元素传递即可。
 * 隐式将这些参数封装成了数组
 * <p>
 * 在使用时,可变参数一定要放在所有参数的最后面。不然系统不能识别
 */
public class ParamMethodDemo {
    public static void main(String[] args) {
//        int[] arr = {1, 2};
//        show(arr);

        show(1, 2, 3, 4, 5, 6);
        show(1, 2, 3, 4);
        show();
    }

    public static void show(int... arr) {
        System.out.println(arr.length);
    }
}
