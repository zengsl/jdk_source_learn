package com.zzz.test.feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * lambda表达式
 *
 * 函数式接口的实现可以使用lambda表达式来替换
 *
 * 什么是函数式接口？ 只有一个抽象方法(不包括默认方法、静态方法)的接口就满足函数式接口的特征，当然也可以用注解@FunctionalInterface来进行标记
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/5/11 2:03 下午
 */
@DisplayName("lambda新特性测试")
public class LambdaTest {


    @DisplayName("lambda表达式")
    @Test
    void lambdaTest() {
        LambdaTest tester = new LambdaTest();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }


    @DisplayName("lambda作用域")
    @Test
    void lambdaScopeTest() {
        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.printf("结果：%s", (param + num));
        // 输出结果为 3
        s.convert(2);
    }


    public interface Converter<T1, T2> {
        void convert(int i);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
