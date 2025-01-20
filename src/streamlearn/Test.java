package streamlearn;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 学习流式编程
 * 文档：
 */
public class Test {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("China", "", "Japan", "USA", "Vietnam");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        /* foreach */
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        /* map */
        List<Integer> numbers = Arrays.asList(3, 2, 5, 7, 8);
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());

        /* filter 用于通过设置的条件过滤元素 */
        /* 获取为空的元素个数 */
        List<String> strings1 = Arrays.asList("a", "b", "", "c", "d");
        long count = strings1.stream().filter(s -> s.isEmpty()).count();

        /* limit */
        Random random1 = new Random();
        random1.ints().limit(10).forEach(System.out::println);
        System.out.println("-------------------------------");

        /* sorted */
        /* 用于对流进行排序 */
        Random random2 = new Random();
        random2.ints().limit(10L).sorted().forEach(System.out::println);

        /* parallelStream */
        List<String> stringList = Arrays.asList("USA", "China", "France");
        stringList.parallelStream().forEach(System.out::println);

        /* Collectors */
        List<String> stringList1 = Arrays.asList("I", "love", "", "cuirutong", "!");
        List<String> filteredList = stringList1.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表：" + filteredList);
        String mergedString = stringList1.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串：" + mergedString);

        /* 统计 */
        List<Integer> numbersList = Arrays.asList(3, 2, 5, 6, 9);
        IntSummaryStatistics stats = numbersList.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数：" + stats.getMax());
        System.out.println("列表中最小的数：" + stats.getMin());
        System.out.println("列表中所有数之和：" + stats.getSum());
        System.out.println("列表中所有数的平均数：" + stats.getAverage());

        System.out.println("the process finish");


    }
}
