package com.bixiangdong.day22;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

/*
需求：实现简单的文本工具，简单描述菜单样式
-----
文件
-----
打开--》点击出现文件选择框，
保存
退出

1. 实现基本框架
2. 添加menubar 打开/保存/退出 textArea
3. 实现frame关闭事件
4. 实现"打开"功能 点击打开 出现filedialog 点击文件 将文件显示在textArea中
 */
public class MyMenuTest {
    public static void main(String[] args) {
        new MyMenu();

    }
}
class MyMenu{
    private Frame f;
    private MenuBar mb;
    private Menu menu;
    private MenuItem openItem;
    private MenuItem saveItem;
    private MenuItem closeItem;
    private TextArea ta;
    private FileDialog openFileDia;
    private File file;
    private FileDialog saveFileDia;

    MyMenu(){
        init();
    }
    private void init(){
        f = new Frame("notepad");
        f.setBounds(300, 200, 500, 400);

        //menubar
        mb=new MenuBar();
        menu = new Menu("文件");
        openItem = new MenuItem("打开");
        saveItem = new MenuItem("保存");
        closeItem = new MenuItem("关闭");
        ta = new TextArea();

        menu.add(openItem);
        menu.add(saveItem);
        menu.add(closeItem);

        mb.add(menu);

        f.add(ta);

        f.setMenuBar(mb);
        myEvent();
        f.setVisible(true);
    }
    private void myEvent(){
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        openItem.addActionListener(new ActionListener() {

            private BufferedReader bufr;

            @Override
            public void actionPerformed(ActionEvent e) {
                openFileDia = new FileDialog(f, "select file", FileDialog.LOAD);
                openFileDia.setVisible(true);
                String dirPath = openFileDia.getDirectory();
                String filePath = openFileDia.getFile();
                //如果非空则说明选择了文件
                if (dirPath == null || filePath == null) {
                    return;
                }
                //如果非空说明要读取新的文件，需要将ta置空
                ta.setText("");
                //将选择的文件展示到ta中
                file = new File(dirPath, filePath);
                try {
                    bufr = new BufferedReader(new FileReader(file));
                    String line=null;
                    while ((line = bufr.readLine()) != null) {
                        ta.append(line+System.lineSeparator());
                    }
                } catch (Exception ex) {
                    throw new RuntimeException("文件找不到");
                } finally {
                    try {
                        bufr.close();
                    } catch (IOException ex) {
                        throw new RuntimeException("io异常");
                    }
                }
            }
        });
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /*
        如果file为空，说明文件不存在，将文件并存入数据
        如果file！=null，说明文件存在，将数据存入文件
         */
        saveItem.addActionListener(new ActionListener() {

            private BufferedWriter bufw;

            @Override
            public void actionPerformed(ActionEvent e) {


                if (file == null) {
                    saveFileDia = new FileDialog(f, "保存", FileDialog.SAVE);
                    saveFileDia.setVisible(true);
                    String dirPath = saveFileDia.getDirectory();
                    String filePath = saveFileDia.getFile();
                    if (saveFileDia == null || filePath == null) {
                        return;
                    }
                    file = new File(dirPath, filePath);
                }
                try {
                    bufw = new BufferedWriter(new FileWriter(file));
                    bufw.write(ta.getText());
                    bufw.flush();
                    bufw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

}
