package com.bixiangdong.day18;

import java.util.Random;

public class MathDemo1 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int r = random.nextInt(10)+1;
            if (r == 0) {
                System.out.println(r);
            }
        }
    }
}
