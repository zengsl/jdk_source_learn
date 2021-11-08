package com.zzz.test.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.StampedLock;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/1 2:16 下午
 */
public class StampedLockTest {

    @Test
    public void test() {
        StampedLock stampedLock = new StampedLock();
        stampedLock.validate(123);

    }
}
