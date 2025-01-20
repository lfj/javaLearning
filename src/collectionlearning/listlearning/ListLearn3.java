package collectionlearning.listlearning;

import java.util.ArrayList;
import java.util.List;

public class ListLearn3 {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("0");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");
        list1.add("9");
        list1.add("10");
        List<String> list2 = list1.subList(0, 6);
        int i = 0;
    }
}
