package com.zwonb;

/**
 * 继承Thread实现多线程
 * Created by zyb on 2017/7/28.
 */
public class ThreadTest extends Thread {

    private int count = 10;

    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println(count);
            if (--count == 0) {
                return;
            }
        }
    }

    public static void main(String[] args){
        new ThreadTest().start();
    }
}
