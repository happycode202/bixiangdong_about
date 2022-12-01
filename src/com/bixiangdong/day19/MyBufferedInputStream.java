package com.bixiangdong.day19;

import java.io.FileInputStream;
import java.io.InputStream;

/*
模拟一个BufferedInpugStream
1. 构造方法 成员变量
2. 带有缓存功能的read方法

InputStream 的read（）方法中，返回值是指针下一位的字节的值，不是长度之类的东西。

毕老师的模拟总体思路比较混乱这里就不重写了。
老师的本意是模仿bufferedInputStream，但并没有写明白。只是一个大致的过程，
 */
public class MyBufferedInputStream {
    private InputStream is;
    MyBufferedInputStream(InputStream is) {
        this.is=is;
    }

    public int myRead() throws Exception{
        int next=0;
        if (next < -1) {
            return -1;
        }
        next = is.read();
        return next;

    }

}
