package com.bixiangdong.day22;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("GUI");
        frame.setSize(500, 200);
        frame.setLocation(900, 500);
//        frame.setLayout(new FlowLayout());
//        frame.setLayout(new BorderLayout());
        frame.setLayout(new GridLayout());
//        Button button = new Button("1");
        frame.add(new Button("1"));
        frame.add(new Button("2"));

        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowclosing");
//                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }
        });
    }
}
