package com.bixiangdong.day21;

import jdk.internal.org.objectweb.asm.commons.RemappingAnnotationAdapter;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/*
管道流
 */
public class PipeStreamDemo {
    public static void main(String[] args) throws IOException {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream();
        in.connect(out);

        Read read = new Read(in);
        Write write = new Write(out);
        new Thread(read).start();
        new Thread(write).start();
    }
}

class Read implements Runnable {
    private PipedInputStream in;

    Read(PipedInputStream in) {
        this.in=in;
    }
    @Override
    public void run() {
        byte[] buf = new byte[1024];
        try {
            int len=in.read(buf);
            String s = new String(buf, 0, len);
            System.out.println(s);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("管道流读取数据异常");
        }
    }
}

class Write implements Runnable {
    private PipedOutputStream out;

    Write(PipedOutputStream out) {
        this.out=out;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            out.write("pipedoutputstreamDemo".getBytes());
            out.close();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("管道流输出错误");
        }
    }
}