package com.zzz.test.feature.ifunction;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/11 2:35 下午
 */
public class GenericMethodRefDemo {

    public static <T> int myOp(MyFunc<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        String[] strs = {"One", "Two", "Three", "Two"};
        int count;
        count = myOp(MyArrayOps::countMatching, vals, 4);
        System.out.println("vals contains " + count + " 4s");
        count = myOp(MyArrayOps::countMatching, strs, "Two");
        myOp(new MyFunc<String>() {
            @Override
            public int func(String[] als, String v) {
                return MyArrayOps.countMatching(als,v);
            }
        },strs,"2");

        System.out.println("strs contains " + count + " Twos");
    }
}
