package com.bixiangdong.day22;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.TreeSet;

public class FrameDeom {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Button button = new Button();

        FrameInit frameInit = new FrameInit(frame, button);
        
    }
}

/*
创建对象的时候直接初始化frame/button
 */
class FrameInit{
    private Frame frame;
    private Button button;

    FrameInit(Frame frame, Button button) {
        init();
    }

    public void init(){
        frame = new Frame("frame");
        //设置frame
        frame.setBounds(300, 200, 500, 400);
        frame.setLayout(new FlowLayout());

        button = new Button("button1");

        frame.add(button);
        frame.setVisible(true);
        myEvent();
        //设置监听事件及解决方式

    }
    public void myEvent(){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowclosing");
                System.exit(0);
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击");
                System.exit(0);
            }
        });
    }

}