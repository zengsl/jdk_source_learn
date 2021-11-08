package com.zzz.test.unsafe;

import java.util.function.Consumer;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/1 2:01 下午
 */
public class UnsafeTest2 {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("lambda");
    }
}
