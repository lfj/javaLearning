package lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Tester {

    public static void main(String[] args) {

        Java8Tester tester = new Java8Tester();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (a, b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (a, b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        GreetingService greetingService1 = message ->
                System.out.println("Hello " + message);
        greetingService1.sayMessage("China");
        greetingService1.sayMessage("Japan");

        List<String> list = Lists.newArrayList("a", "b", "c", "d");
        list.stream().map(str -> {
            return str + "";
        }).collect(Collectors.toList());

        Stream<String> stream = Stream.of("one", "two", "three", "four");
        stream.peek(System.out::println);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
