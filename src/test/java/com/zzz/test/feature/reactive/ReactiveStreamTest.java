package com.zzz.test.feature.reactive;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * 响应式流测试类
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/5/12 1:58 下午
 */
public class ReactiveStreamTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void test1() throws InterruptedException {
        logger.info("开始！！！");
        //1.创建 生产者Publisher JDK9自带的 实现了Publisher接口
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        //2.创建 订阅者 Subscriber，需要自己去实现内部方法
        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("订阅成功。。");
                subscription.request(1);
                System.out.println("订阅方法里请求一个数据");
            }

            @Override
            public void onNext(Integer item) {
                logger.info("【onNext 接受到数据 item : {}】 ", item);
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                logger.info("【onError 出现异常】");
                subscription.cancel();
            }

            @Override
            public void onComplete() {
                logger.info("【onComplete 所有数据接收完成】");
            }
        };

        //3。发布者和订阅者 建立订阅关系 就是回调订阅者的onSubscribe方法传入订阅合同
        publisher.subscribe(subscriber);

        //4.发布者 生成数据
        for (int i = 1; i <= 5; i++) {
            logger.info("【生产数据 {} 】", i);
            //submit是一个阻塞方法，此时会调用订阅者的onNext方法
            publisher.submit(i);
        }

        //5.发布者 数据都已发布完成后，关闭发送，此时会回调订阅者的onComplete方法
        publisher.close();

        //主线程睡一会
        Thread.currentThread().join(100000);
    }

    @Test
    void test2() throws InterruptedException {
        logger.info("开始！！！");
        //1.创建 生产者Publisher JDK9自带的 实现了Publisher接口
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        //2.创建 订阅者 Subscriber，需要自己去实现内部方法
        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("订阅成功。。");
                subscription.request(1);
                System.out.println("订阅方法里请求一个数据");
            }

            @Override
            public void onNext(Integer item) {
                logger.info("【onNext 接受到数据 item : {}】 ", item);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscription.request(1);

            }

            @Override
            public void onError(Throwable throwable) {
                logger.info("【onError 出现异常】");
                subscription.cancel();
            }

            @Override
            public void onComplete() {
                logger.info("【onComplete 所有数据接收完成】");
            }
        };

        //3。发布者和订阅者 建立订阅关系 就是回调订阅者的onSubscribe方法传入订阅合同
        publisher.subscribe(subscriber);

        //4.发布者 生成数据
        //发布者 生成数据
        for (int i = 1; i <= 1000; i++) {
            logger.info("【生产数据 {} 】", i);
            //submit是一个阻塞方法，此时会调用订阅者的onNext方法
            publisher.submit(i);
        }


        //5.发布者 数据都已发布完成后，关闭发送，此时会回调订阅者的onComplete方法
        publisher.close();

        //主线程睡一会
        Thread.currentThread().join(100000);
    }


}
