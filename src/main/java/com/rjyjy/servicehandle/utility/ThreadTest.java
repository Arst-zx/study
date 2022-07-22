package com.rjyjy.servicehandle.utility;

import java.util.Random;

/**
 * @author: 章鑫
 * @Project_name：Study
 * @Name: Thread
 * @date: 2020-06-02 08:59
 * @Description:
 **/
public class ThreadTest extends Thread{

    private int i;

    public ThreadTest(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        super.run();
        System.out.println(i);
    }

    public static void main(String[] args) {

        Thread thread_1 = new ThreadTest(1);
        Thread thread_2 = new ThreadTest(2);
        Thread thread_3 = new ThreadTest(3);
        Thread thread_4 = new ThreadTest(4);
        Thread thread_5 = new ThreadTest(5);
        Thread thread_6 = new ThreadTest(6);
        Thread thread_7 = new ThreadTest(7);
        Thread thread_8 = new ThreadTest(8);
        Thread thread_9 = new ThreadTest(9);
        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();
        thread_5.start();
        thread_6.start();
        thread_7.start();
        thread_8.start();
        thread_9.start();
    }
}

class MyThread extends Thread {

    public static int num = 10;

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
        try {
            for (int i = 0; i < num; i++) {
                Random random = new Random();
                int time = random.nextInt()/10000000;
                if (time < 0) {
                    time = -time;
                }
                Thread.sleep(time);
                System.out.println("run:" + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.setName("myThread");
            myThread.start();
            for (int i = 0; i < num; i++) {
                Random random = new Random();
                int time = random.nextInt()/10000000;
                if (time < 0) {
                    time = - time;
                }
                System.out.println(time);
                Thread.sleep(time);
                System.out.println("main:" + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("运行结束！");
    }
}
