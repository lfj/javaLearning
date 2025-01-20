package lambda;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class ReduceLearn {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});

        // 求集合元素之和的第一种方法
        Integer result = stream.reduce(0, Integer::sum);
        System.out.println(result);

        // 求集合元素之和的第二种方法
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce((i, j) -> i + j).ifPresent(System.out::println);

        // 求集合中的最大值的第一种方法
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce(Integer::max).ifPresent(System.out::println);

        // 求集合中的最大值的第二种方法
        stream = Arrays.stream(new Integer[]{1 , 4, 5, 6, 8, 3, 1, 1});
        stream.reduce((i, j) -> i > j ? i : j).ifPresent(System.out::println);

        // 求集合中的最小值
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce(Integer::min).ifPresent(System.out::println);

        // 求逻辑求乘积
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        int result2 = stream.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);
        Optional.of(result2).ifPresent(System.out::println);

        // 求两个元素之和
        System.out.println(getSum(1, 2, (a, b) -> a + b));
    }

    public static Integer getSum(Integer a, Integer b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }
}
