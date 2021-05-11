package com.zzz.test.feature.ifunction;

import java.util.function.Supplier;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/11 2:18 下午
 */
public class Car {

    /**
     * Supplier是jdk1.8的接口，这里和lamda一起使用了
     */
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this);
    }
}
