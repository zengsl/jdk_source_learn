package com.zzz.test.hashmap;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zengsl
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map<Integer, Integer> testMap = new HashMap<>(2);
        testMap.put(1, 1);
        testMap.put(1, 2);
        testMap.put(17, 1);

    }
}
