package com.bixiangdong.day22;


import java.awt.*;
import java.awt.event.*;

class MouseAndKeyEvent {
    private Frame f;
    private Button but;
    private TextField tf;

    MouseAndKeyEvent() {
        init();
    }

    private void init() {
        f = new Frame("myframe");
        but = new Button("button1");
        tf = new TextField();

        f.setBounds(300, 200, 500, 400);
        f.setLayout(new FlowLayout());
        tf.setColumns(20);

        f.add(but);
        f.add(tf);
        //设置监听事件
        myEvent();
        f.setVisible(true);

    }

    private void myEvent() {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("aciton ok");
            }
        });
        but.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"......" +e.getKeyCode());
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("control + enter is run");
                }
            }
        });
        but.addMouseListener(new MouseAdapter() {
            int clickCount = 0;
            int count = 0;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.out.println("双击" + clickCount++);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("鼠标进入到该组件" + count++);
            }
        });
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (!(keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9)) {
                    System.out.println(keyCode + "是非法的");
                    e.consume();
                }
            }
        });
    }
}

public class MouseAndKeyDemo {
    public static void main(String[] args) {
        new MouseAndKeyEvent();

    }
}
