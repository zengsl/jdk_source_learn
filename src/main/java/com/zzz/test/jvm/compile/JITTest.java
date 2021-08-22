package com.zzz.test.jvm.compile;

/**
 * 设置JVM参数：
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintCompilation -XX:+PrintInlining -XX:+PrintCodeCache -XX:+PrintCodeCacheOnCompilation -XX:+TraceClassLoading -XX:+LogCompilation -XX:LogFile=/Users/zengsl/Desktop
 *
 * 日志通过JITwatch进行查看
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/7/28 9:19 上午
 */
public class JITTest {


    static class Fruit {
        public Fruit(String name) {
            this.name = name;
        }

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Person {
        public Person(String name, Integer age, Fruit favoriteFruit) {
            this.name = name;
            this.age = age;
            this.favoriteFruit = favoriteFruit;
        }

        String name;
        Integer age;
        Fruit favoriteFruit;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Fruit getFavoriteFruit() {
            return favoriteFruit;
        }

        public void setFavoriteFruit(Fruit favoriteFruit) {
            this.favoriteFruit = favoriteFruit;
        }
    }

    public static void main(String[] args) {
        Person ming = new Person("xiaoming",18,new Fruit("apple"));
        Person tony = new Person("Tony",18,new Fruit("apple"));
    }
}
