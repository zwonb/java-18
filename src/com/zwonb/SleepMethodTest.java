package com.zwonb;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 线程的睡眠
 * Created by zyb on 2017/7/29.
 */
public class SleepMethodTest extends JFrame {

    private Thread thread;
    private static Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN,
            Color.GREEN, Color.ORANGE, Color.YELLOW, Color.RED,
            Color.PINK, Color.LIGHT_GRAY};
    private static final Random random = new Random();

    private static Color getColor() {
        return colors[random.nextInt(colors.length)];
    }

    public SleepMethodTest() {
        thread = new Thread(new Runnable() {
            int x = 30;
            int y = 50;
            @Override
            public void run() {
                while (true) {
                    try {
                        //线程睡眠100毫秒
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Graphics graphics = getGraphics();
                    graphics.setColor(getColor());
                    graphics.drawLine(x, y, 100,y++);
                    if (y >= 80) {
                        y=50;
                    }
                }
            }
        });

        thread.start();

    }

    public static void main(String[] args) {
        init(new SleepMethodTest(),100,100);
    }

    private static void init(JFrame jFrame, int width, int height) {
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(width, height);
        jFrame.setVisible(true);
    }
}
