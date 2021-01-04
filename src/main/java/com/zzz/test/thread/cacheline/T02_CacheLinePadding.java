package com.zzz.test.thread.cacheline;

/**
 *
 * 缓存行对齐
 *
 * 缓存行 64个字节
 *
 * T包含8个long类型的变量，一个变量8个字节，8 * 8 = 64
 *
 * 两个线程在并发修改的时候x的时候，因为不是在同一个缓存行，所以不会造成相互影响的情况（volatile涉及CPU缓存一致性问题）
 */
public class T02_CacheLinePadding {


    private static class Padding {
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    private static class T extends Padding {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                arr[1].x = i;
            }
        });

        final long start = System.nanoTime();

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start)/100_0000);
    }
}
