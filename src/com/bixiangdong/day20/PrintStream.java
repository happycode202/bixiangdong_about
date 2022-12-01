package com.bixiangdong.day20;


import sun.font.TrueTypeFont;

import java.io.*;

public class PrintStream {
    public static void main(String[] args) throws IOException {

        //键盘录入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new FileOutputStream("a.txt"), true);
        String line=null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            pw.println(line.toUpperCase());
        }
        pw.close();
        bufr.close();

    }
}
