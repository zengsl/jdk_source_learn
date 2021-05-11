package com.zzz.test.feature.ifunction;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/11 2:35 下午
 */
public class MyArrayOps {

    public static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for (T val : vals) {
            if (val == v) {
                count++;
            }
        }
        return count;
    }

}