package com.bixiangdong.day22;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class MyWindowDemo {
    public static void main(String[] args) {
        new MyWindowDemo();
    }

    private Frame f;
    private TextField tf;
    private Button but;
    private TextArea ta;
    private Dialog dia;
    private Button butDia;
    private Label lab;

    MyWindowDemo() {
        init();
    }

    private void init() {
        f = new Frame("目录内文件查询");
        f.setBounds(300, 200, 500, 400);
        f.setLayout(new FlowLayout());
        dia = new Dialog(f, "error", true);
        dia.setBounds(400, 300, 240, 150);
        dia.setLayout(new FlowLayout());
        butDia = new Button("确定");
        lab = new Label("您输入的地址 错误，请重新输入");

        but = new Button("查询");

        tf = new TextField();
        tf.setColumns(45);

        ta = new TextArea();
        ta.setColumns(40);
        ta.setRows(20);

        f.add(tf);
        f.add(but);
        f.add(ta);
        f.setVisible(true);
        myEvent();
    }

    private void myEvent() {
        /**
         * 实现关闭事件
         */
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDir();
            }
        });
        dia.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("dia run");
                dia.setVisible(false);
            }
        });
        butDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("butdia run");
                dia.setVisible(false);
            }
        });

    }

    private void showDir() {

        String text = tf.getText();
        File file = new File(text);
        if (file.exists() && file.isDirectory()) {
            String[] dirPath = file.list();
            for (String name : dirPath) {
                ta.append(name + System.lineSeparator());
            }
        } else {



            dia.add(lab);
            dia.add(butDia);
            dia.setVisible(true);

        }
        tf.setText("");
    }
}

/*
需求：
1. 在textfield中输入地址，如果存在，在TextArea中显示该地址下的所有文件，如果不存在，显示dialog，并显示提示信息

frame [texfield buttong textarea]
dialog[label button]
 */
