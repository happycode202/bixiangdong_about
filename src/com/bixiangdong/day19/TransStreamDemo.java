package com.bixiangdong.day19;

import java.io.*;

/*
通过刚才的键盘录入一行数据并打印其大写，发现其实就是读一行数据的原理。也就是readLine方法。

能不能直接使用readLine方法来完成键盘录入的一行数据的读取呢？

readLine（）方法是BufferedReader中的方法

而键盘录入的read方法是字节流InputStream方法

那么能不能将字节流转乘字符流，再使用字符流缓冲区的方法呢？


1.
源：键盘录入
目的：控制台

2.想要把键盘的输入数据记录到文件中
源：键盘
目的：文件

3.想要将一个文件的数据打印到控制台上
源：文件
目的：控制台

流操作的基本规律：
最痛苦的就是流对象很多，不知道该用哪一个

通过三个明确来完成：
1. 明确源和目的
    源：输入流 InputStream Reader
    目的：输出流 OutputStream Writer
2. 操作的数据是否是纯文本
    是：字符流
    否：字节流
3. 当体系明确后在明确要使用哪个具体的对象
    通过设备来进行区分
    源设备：内存 、硬盘、键盘
    目的设备：内存、硬盘、控制台

需求：
1. 将一个文件中的数据存储到另一个文件中：复制文件
    源：因为是源，所以使用读取流.InputStream Reader
    是不是操作文本文件。
    是：这时就可以选择Reader
    这时体系就明确了

    接下来明确要使用该体系中的哪个对象
    明确设备：硬盘上一个文件
    Reader体系中可以操作对象的是fileReader

    是否需要提高效率：是 加入Reader体系中的带有缓冲区的类BuffereReader
    FileReader fr=new FileReader("a.txt);
    BufferedReader bufr=new BufferedReader(fr);


    目的：outputStream Writer
    是否是纯文本
    是：writer
    设备：硬盘上的一个文件
    writer体系中能可以操作文件的对象是FileWriter
    是否需要提高效率：是：加入bufferedwriter
    FileWriter fw= new FileWriter("b.txt");
    BufferedWriter bufw=new BufferedWriter(fw);

练习：
1. 将图片文件中数据存储到另一个文件中，复制文件：要按照上面的格式完成三个步骤
2. 将键盘录入的数据保存到文件中
inputStream -->reader-->inputStreamReader-->bufferedReader
outputSreeam-->writer-->outputStreamWriter-->bufferedWriter


FileWriter使用默认编码表。
存储时，需要加入指定的码表，而指定码表只有转换流可以指定。
所以要使用对象的outputStreamWriter
而该转换流对象要接受一个字节流输出流,而且还可以操作文件的字节输出流。FileOutputStream

OutputStreamWriter osw= new OutputStreamWriter(new FileOutputStream("d.txt"）,"UTF-8")

需要高效吗"?需要
BufferedWriter bw=new BufferedWriter(osw);

所以，记住，转换流什么时候使用，字符和字节之间的桥梁。通常，涉及到字符编码转换时需要使用转换流

练习：将一个文本数据打印在控制台上
 */
public class TransStreamDemo {
    public static void main(String[] args) throws IOException {
        //转换流是将字节流转换成字符流，先创建一个字节流对象
//        InputStream in = System.in;
//        InputStreamReader isr = new InputStreamReader(in);
//        BufferedReader bufr = new BufferedReader(isr);

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        //转换流输出
        //字节输出流
//        OutputStream os=System.out;
//        OutputStreamWriter osw = new OutputStreamWriter(os);
//        BufferedWriter bufw = new BufferedWriter(osw);
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        while ((line = bufr.readLine()) != null) {
            if (line.equals("over")) {
                break;
            }
//            System.out.println(line.toUpperCase());
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }
        bufw.close();
        bufr.close();
    }
}
