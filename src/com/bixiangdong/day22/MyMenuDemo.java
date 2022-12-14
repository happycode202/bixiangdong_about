package com.bixiangdong.day22;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyMenuDemo {
    public static void main(String[] args) {

        new MenuDemo();
    }
}
class MenuDemo{
    private Frame frame;
    private MenuBar menuBar;
    private Menu menu;
    private MenuItem closefile,openfile,savefile;
    MenuDemo(){
        init();
    }
    public void init(){
        frame = new Frame("菜单");
        menuBar = new MenuBar();
        menu = new Menu("file");
        openfile = new MenuItem("openfile");
        closefile = new MenuItem("closefile");
        savefile = new MenuItem("savefile");


        frame.setBounds(400, 300, 500, 300);
        frame.setLayout(new FlowLayout());

        menu.add(openfile);
        menu.add(savefile);
        menu.add(closefile);
        menuBar.add(menu);
        frame.setMenuBar(menuBar);

        myEvent();
        frame.setVisible(true);
    }
    private void myEvent(){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}
