package com.bixiangdong.day19;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
需求：复制一张图片到指定位置

1. 创建输入输出流 因为是图片，要使用字节流
2. 读取数据，输出数据
3. 关闭流
 */
public class CopyPic {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("1.jpg");
            fos = new FileOutputStream("copy1.jpg");
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException("复制文件失败");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("读取流失败");
            }

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("写入文件失败");
            }
        }
    }
}
