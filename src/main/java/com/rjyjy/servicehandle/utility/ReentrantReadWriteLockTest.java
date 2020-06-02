package com.rjyjy.servicehandle.utility;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：Study
 * @Name: ReentrantReadWriteßLockTest
 * @date: 2019-10-21 14:56
 * @Description: 读写锁
 **/

public class ReentrantReadWriteLockTest {

    public static void main(String[] args) throws InterruptedException {

        // 读写锁
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        // 线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                // 获取写锁
                reentrantReadWriteLock.writeLock().lock();

                System.out.println("线程1启动！");

                // 释放写锁
                reentrantReadWriteLock.writeLock().unlock();

            }
        });

        /**
         * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
         * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        /**
         * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
         * 因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
         * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()。可参考PreloadDataCache。
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        /**
         * 创建一个定长线程池，支持定时及周期性任务执行。
         * 表示延迟1秒后每3秒执行一次。
         * ScheduledExecutorService比Timer更安全，功能更强大。
         */
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

        /**
         * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
         *
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        // 获取两次写锁
        reentrantReadWriteLock.writeLock().lock();
        reentrantReadWriteLock.writeLock().lock();

        // 启动线程
        thread.start();

        // 可缓存线程池启动线程
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {

                // 获取写锁
                reentrantReadWriteLock.writeLock().lock();

                System.out.println("线程cachedThreadPool启动！");

                // 释放写锁
                reentrantReadWriteLock.writeLock().unlock();

            }
        });

        // 关闭线程池
        cachedThreadPool.shutdown();

        // 定长线程池启动线程
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {

                // 获取写锁
                reentrantReadWriteLock.writeLock().lock();

                System.out.println("线程fixedThreadPool启动！");

                // 释放写锁
                reentrantReadWriteLock.writeLock().unlock();

            }
        });

        // 关闭线程池
        fixedThreadPool.shutdown();

        // 定时线程池启动线程
        scheduledThreadPool.execute(new Runnable() {
            @Override
            public void run() {

                // 获取写锁
                reentrantReadWriteLock.writeLock().lock();

                System.out.println("线程scheduledThreadPool启动！");

                // 释放写锁
                reentrantReadWriteLock.writeLock().unlock();

            }
        });

        // 关闭线程池
        scheduledThreadPool.shutdown();

        // 单线程池启动线程
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {

                // 获取写锁
                reentrantReadWriteLock.writeLock().lock();

                System.out.println("线程singleThreadExecutor启动！");

                // 释放写锁
                reentrantReadWriteLock.writeLock().unlock();

            }
        });

        // 关闭线程池
        singleThreadExecutor.shutdown();

        Thread.sleep(200);
        System.out.println("线程跑一次！");

        // 对应释放两次写锁,释放后才执行run()方法
        reentrantReadWriteLock.writeLock().unlock();
        reentrantReadWriteLock.writeLock().unlock();

    }
}
