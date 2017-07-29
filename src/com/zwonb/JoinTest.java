package com.zwonb;

import javax.swing.*;
import java.awt.*;

/**
 * 线程的加入
 * Created by zyb on 2017/7/29.
 */
public class JoinTest extends JFrame {

    private Thread threadA;
    private Thread threadB;
    JProgressBar progressBarA = new JProgressBar();
    JProgressBar progressBarB = new JProgressBar();
    int count = 0;

    public JoinTest() {
        super();
        getContentPane().add(progressBarA, BorderLayout.NORTH);
        getContentPane().add(progressBarB, BorderLayout.SOUTH);
        progressBarA.setStringPainted(true);
        progressBarB.setStringPainted(true);

        threadA = new Thread(new Runnable() {

            int count = 0;

            @Override
            public void run() {
                while (true) {
                    progressBarA.setValue(++count);
                    try {
                        Thread.sleep(100);//线程a睡眠100毫秒
                        threadB.join();//线程b加入(只有当线程b执行完毕才能继续执行线程a
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();

        threadB = new Thread(new Runnable() {

            int count = 0;

            @Override
            public void run() {
                while (true) {

                    progressBarB.setValue(++count);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (count == 100) {
                        break;
                    }
                }
            }
        });

        threadB.start();
    }

    public static void main(String[] args) {
        init(new JoinTest(), 300, 300);
    }

    private static void init(JFrame jFrame, int width, int height) {
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(width, height);
        jFrame.setVisible(true);
    }
}
