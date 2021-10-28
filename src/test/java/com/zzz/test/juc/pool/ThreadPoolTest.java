package com.zzz.test.juc.pool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://cloud.tencent.com/developer/article/1330398
 *https://tech.meituan.com/2020/04/02/java-pooling-pratice-in-meituan.html
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/10/26 3:39 下午
 */
public class ThreadPoolTest {

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }


    @Test
    public void basicDataTest() {
        System.out.println(COUNT_BITS);
        System.out.println(Integer.toBinaryString(1 << COUNT_BITS));
        System.out.println(Integer.toBinaryString(CAPACITY));
        System.out.println("runState");
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(Integer.toBinaryString(SHUTDOWN));
        System.out.println(Integer.toBinaryString(STOP));
        System.out.println(Integer.toBinaryString(TIDYING));
        System.out.println(Integer.toBinaryString(TERMINATED));

        System.out.println(TERMINATED>=TIDYING);
        System.out.println(STOP>=TIDYING);
        System.out.println(SHUTDOWN>=TIDYING);
        System.out.println(RUNNING>=TIDYING);

    }

    @Test
    public void executePool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            System.out.println("测试");
        });
    }


}
