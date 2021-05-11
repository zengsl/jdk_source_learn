package com.zzz.test.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zengsl
 */
public class ReentrantLockTest2 {

    private static final Lock LOCK = new ReentrantLock();

    private static final int LOOP_SIZE = 200;

    public static void test() {
        for (int i = 0; i < LOOP_SIZE; i++) {
            LOCK.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取了锁");
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread("线程A") {
            @Override
            public void run() {
                test();
            }
        }.start();

        new Thread("线程B") {
            @Override
            public void run() {
                test();
            }
        }.start();
    }
}
