package com.zzz.test.spring.autowired;

import java.util.stream.Stream;

/**
 * 简单实现autowired
 *
 * @author zengsl
 */
public class TestAutowired {

    public static void main(String[] args) {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object obj;
                try {


                    obj = type.newInstance();
                    field.set(userController, obj);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(userController.getUserService());
    }
}
