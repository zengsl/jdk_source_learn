package com.zzz.test.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zengsl
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        // 1.初始化选择公平锁、非公平锁
        ReentrantLock lock = new ReentrantLock(true);
        // 2.可用于代码块
        lock.lock();
        try {
            try {
                // 3.支持多种加锁方式，比较灵活; 具有可重入特性
                if(lock.tryLock(100, TimeUnit.MILLISECONDS)){ }
            } finally {
                // 4.手动释放锁
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }

    }
}
