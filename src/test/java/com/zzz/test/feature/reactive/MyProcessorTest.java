package com.zzz.test.feature.reactive;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/12 2:16 下午
 */
public class MyProcessorTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    void processorTest() throws InterruptedException {

        //创建发布者
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        //创建 Processor 即是发布者也是订阅者
        MyProcessor myProcessor = new MyProcessor();

        //创建最终订阅者
        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                log.info("【onNext 从Processor 接受到过滤后的 数据 item : {}】 ", item);
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("【onError 出现异常】");
                subscription.cancel();
            }

            @Override
            public void onComplete() {
                log.info("【onComplete 所有数据接收完成】");
            }
        };

        //建立关系 发布者和处理器， 此时处理器扮演 订阅者
        publisher.subscribe(myProcessor);

        //建立关系 处理器和订阅者  此时处理器扮演
        myProcessor.subscribe(subscriber);

        //发布者发布数据
        publisher.submit(1);
        publisher.submit(2);
        publisher.submit(3);
        publisher.submit(4);

        publisher.close();
        TimeUnit.SECONDS.sleep(2);

    }
}
