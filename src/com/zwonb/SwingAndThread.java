package com.zwonb;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Runnable接口实现多线程
 * Created by zyb on 2017/7/28.
 */
public class SwingAndThread extends JFrame {
    
    private JLabel jl = new JLabel();
    private static Thread thread;
    private int count = 0;
    private Container container = getContentPane();

    public SwingAndThread(){
        setBounds(300,200,250,100);
        container.setLayout(null);
        URL url = SwingAndThread.class.getResource("xue.png");
        ImageIcon icon = new ImageIcon(url);
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10,10,200,50);
        jl.setOpaque(true);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<=200) {
                    jl.setBounds(count,10,200,50);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    count+=4;
                    if (count == 200) {
                        count = 10;
                    }
                }
            }
        });

        thread.start();
        container.add(jl);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args){
        new SwingAndThread();
    }
}
