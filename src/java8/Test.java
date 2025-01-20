package java8;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
@Builder
class Student {
    private String stuNo;
    private String name;
    private int num;
}

public class Test {

    public static int getNum(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] > array[j]) {
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                j --;
            } else if (array[i] < array[j]) {
                i ++;
            } else {
                i ++;
                j --;
            }
        }
        return array[i];
    }

    public static void main(String[] args) {
        int [] array = new int[]{2, 1, 5, 6, 7};

        int [] array1 = new int[]{1, 2, 5, 6, 7};
        System.out.println(getNum((array)));
    }
}
