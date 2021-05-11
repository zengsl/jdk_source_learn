package com.zzz.test.juc;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        t1.join();
    }
}
