package com.zwonb;

import javax.swing.*;
import java.awt.*;

/**
 * 线程的优先级
 * Created by zyb on 2017/7/29.
 */
public class PriorityTest extends JFrame {

    private static final long serialVersionUID = 1L;
    private Thread threadA;
    private Thread threadB;
    private Thread threadC;
    private Thread threadD;

    public PriorityTest() {
        getContentPane().setLayout(new GridLayout(4, 1));
        // 分别实例化4个线程
        final JProgressBar progressBar = new JProgressBar();
        final JProgressBar progressBar2 = new JProgressBar();
        final JProgressBar progressBar3 = new JProgressBar();
        final JProgressBar progressBar4 = new JProgressBar();
        getContentPane().add(progressBar);
        getContentPane().add(progressBar2);
        getContentPane().add(progressBar3);
        getContentPane().add(progressBar4);
        progressBar.setStringPainted(true);
        progressBar2.setStringPainted(true);
        progressBar3.setStringPainted(true);
        progressBar4.setStringPainted(true);
        threadA = new Thread(new MyThread(progressBar));
        threadB = new Thread(new MyThread(progressBar2));
        threadC = new Thread(new MyThread(progressBar3));
        threadD = new Thread(new MyThread(progressBar4));
        setPriority("threadA", 5, threadA);
        setPriority("threadB", 5, threadB);
        setPriority("threadC", 4, threadC);
        setPriority("threadD", 3, threadD);
    }

    // 定义设置线程的名称、优先级的方法
    private static void setPriority(String threadName, int priority, Thread t) {
        t.setPriority(priority); // 设置线程的优先级
        t.setName(threadName); // 设置线程的名称
        t.start(); // 启动线程
    }


    public static void main(String[] args) {
        init(new PriorityTest(), 200, 200);
    }

    private static void init(JFrame jFrame, int width, int height) {
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(width, height);
        jFrame.setVisible(true);
    }
}
