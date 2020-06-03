package com.rjyjy.servicehandle.utility;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：Study
 * @Name: RunnableTest
 * @date: 2020-06-02 15:39
 * @Description:
 **/

class MyThreadOne extends Thread {

    private int i = 5;

    @Override
    synchronized public void run() {
        super.run();
        i--;
        System.out.println(Thread.currentThread().getName() + ": " + i);
    }

    public static void main(String[] args) {
        MyThreadOne myThread = new MyThreadOne();

        Thread thread1 = new Thread(myThread, "线程1");
        Thread thread2 = new Thread(myThread, "线程2");
        Thread thread3 = new Thread(myThread, "线程3");
        Thread thread4 = new Thread(myThread, "线程4");
        Thread thread5 = new Thread(myThread, "线程5");
        Thread thread6 = new Thread(myThread, "线程6");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}

public class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest, "线程1");
        thread.start();
    }
}
