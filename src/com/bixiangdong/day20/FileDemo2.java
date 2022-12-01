package com.bixiangdong.day20;

import com.bixiangdong.day19.MyBufferedInputStream;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo2 {
    public static void main(String[] args) {
        listDemo2();

    }
    //filenameFilter过滤
    public static void listDemo2(){
        File f = new File("/Users/sunhl/Downloads/rime-ice/");
        String[] name = f.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
//                return true;
            }
        });
        System.out.println("leng:" +name.length);
        for (String n :
                name) {
            System.out.println(n);
        }

    }

    public static void listDemo() {
        File f = new File("/");
        String[] names = f.list();
        for (String name :
                names) {
            System.out.println(name);
        }
    }

    private static void listRootsDemo() {
        File[] files = File.listRoots();
        for (File f :
                files) {
            System.out.println(f.length());
        }
    }
}
