package com.zwonb;

import javax.swing.*;

/**
 * 线程的优先级--线程
 * Created by zyb on 2017/7/29.
 */
public class MyThread implements Runnable {

    private final JProgressBar progressBar;
    int count = 0;

    public MyThread(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        while (true) {
            progressBar.setValue(count += 10); // 设置滚动条的值每次自增10
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("当前线程序被中断");
            }
        }

    }
}
