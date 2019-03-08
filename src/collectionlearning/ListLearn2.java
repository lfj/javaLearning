package collectionlearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 实现List与数组之间的转换
 */
public class ListLearn2 {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        /* List转换成数组 */
        String[] strArray = arrayList.toArray(new String[arrayList.size()]);
        for (String str : strArray) {
            System.out.println(str);
        }

        /* 数组转换成List */
        String[] strArray2 = new String[]{"a", "b", "c", "d"};
        List<String> stringList = Arrays.asList(strArray2);
        System.out.println(stringList);/* list可以直接打印出来 */
    }
}
