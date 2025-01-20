package collectionlearning.listlearning;

import java.util.ArrayList;
import java.util.List;

public class ListLearn2 {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        list1.add("f");
        list1.add("f");
        list1.add("a");

        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("d");

        list1.removeAll(list2);
    }
}
