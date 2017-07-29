package com.zwonb;

/**
 * 线程同步问题
 * Created by zyb on 2017/7/29.
 */
public class ThreadSafeTest implements Runnable {

    int count = 10;

    @Override
    public void run() {
        while (true) {
            //加上同步锁，避免数据错乱--同步块
            synchronized ("") {
                if (count > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(--count);
                }
            }

            //第二种使用同步方法
//            doSomething();
        }
    }

    /**
     * 同步方法
     */
    private synchronized void doSomething(){
        if (count > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(--count+"");
        }
    }

    public static void main(String[] args) {
        ThreadSafeTest threadSafeTest = new ThreadSafeTest();
        Thread threadA = new Thread(threadSafeTest);
        Thread threadB = new Thread(threadSafeTest);
        Thread threadC = new Thread(threadSafeTest);
        Thread threadD = new Thread(threadSafeTest);
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
