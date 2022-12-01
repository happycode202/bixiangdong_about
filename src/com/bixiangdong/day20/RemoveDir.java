package com.bixiangdong.day20;

import java.io.File;

/*
删除一个带内容的目录
删除原理
在windows中，删除目录从里面网外删除。
既然从里网外删除，那就需要用到递归。
 */
public class RemoveDir {
    public static void main(String[] args) {
        File f = new File("/Users/sunhl/Downloads/rime-ice");
        removeDir(f);
    }

    public static void removeDir(File f) {
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                removeDir(files[i]);
            } else {
                System.out.println(files[i].toString() + "file-----" + files[i].delete());//删除所有文件
            }
        }
        System.out.println(f.toString() + "dir------" + f.delete());//每次递归调用的最后，删除最后的文件夹
    }
}
