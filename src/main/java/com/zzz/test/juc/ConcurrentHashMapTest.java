package com.zzz.test.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/8 10:22 上午
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>(8);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 2);
        map.put(4, 2);
        map.put(5, 2);
        map.put(6, 2);
        map.put(7, 2);
        map.put(8, 2);
        map.put(9, 2);
        map.put(17, 3);

    }
}
