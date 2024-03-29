package com.zzz.test.thread.jmm;

import java.util.Arrays;

public class Disorder {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            Thread one = new Thread(() -> {
                a = 1;
                x = b;

            });


            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });

            one.start();
            other.start();
            one.join();
            other.join();
            System.out.printf("第%d次(%d,%d)", i, x, y);

            if (x == 0 && y == 0) {
                System.err.println();
                break;
            } else {

            }

        }


    }

}
