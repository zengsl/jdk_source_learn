package com.zzz.test.juc.future;

import java.util.concurrent.*;

/**
 * http://www.ideabuffer.cn/2017/04/06/FutureTask%E6%BA%90%E7%A0%81%E8%A7%A3%E6%9E%90/
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 9:16 上午
 */
public class FutureTest {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> stringFuture = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000_000);
                return "async thread";
            }
        });
//        Thread.sleep(1000_00);
        System.out.println("main thread");
//        System.out.println(stringFuture.get());

        ExecutorService executor2 = Executors.newCachedThreadPool();
        final Thread[] subThread = {null};
        for (int i = 0; i < 4; i++) {
            Future<?> submit = executor2.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        subThread[0] = Thread.currentThread();
                        System.out.println(stringFuture.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        subThread[0].interrupt();

    }

}
