package com.zzz.test.feature;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/11 3:42 下午
 */
public class StreamTest {

    @Test
    void mapTest() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","","", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);


        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

        List<String> strList = Arrays.asList("a", "ba", "bb", "abc", "cbb", "bba", "cab");
        Map<Integer, String> strMap;

        strMap = strList.stream()
                .collect( Collectors.toMap(strList::indexOf, str -> str ) );

        strMap.forEach((key, value) -> {
            System.out.println(key+"::"+value);
        });
    }

}
