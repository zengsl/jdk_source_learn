package com.zzz.test.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zengsl
 */
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(3, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(4);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }


    static class A implements Runnable {


        @Override
        public void run() {
            System.out.println(3);
        }
    }

}
