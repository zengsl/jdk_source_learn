package com.zzz.test.unsafe;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/11/1 1:48 下午
 */
public class UnsafeTest {

    @Test
    public void classOperateTest() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("lambda");
    }

    public void barrierTest() {
        // unsafe的内存屏障在StampedLock中运用
        // StampedLock.validate
    }
}
