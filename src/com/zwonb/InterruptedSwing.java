package com.zwonb;

import javax.swing.*;
import java.awt.*;

/**
 * 线程的中断
 * Created by zyb on 2017/7/29.
 */
public class InterruptedSwing extends JFrame {

    Thread thread;

    public InterruptedSwing() {
        super();
        JProgressBar jProgressBar = new JProgressBar();
        getContentPane().add(jProgressBar, BorderLayout.NORTH);
        jProgressBar.setStringPainted(true);
        thread = new Thread(new Runnable() {

            int count = 0;

            @Override
            public void run() {
                while (true) {
                    jProgressBar.setValue(++count);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("当前线程程序被中断");
                        break;
                    }
                }
            }
        });
        thread.start();//启动线程
        thread.interrupt();//中断线程
    }

    public static void main(String[] args) {
        init(new InterruptedSwing(), 200, 200);
    }

    private static void init(JFrame jFrame, int width, int height) {
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(width, height);
        jFrame.setVisible(true);
    }

}
