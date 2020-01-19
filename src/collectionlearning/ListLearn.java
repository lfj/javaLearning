package collectionlearning;

import net.sf.cglib.core.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * 该类探究的是如何求ArrayList集合的交集 并集 差集 去重复并集
 */
public class ListLearn {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("android");
        list.add("java");
        List<String> list1 = new ArrayList<>(list);
        List<String> list2 = list.subList(0, list.size());
        list2.add("unix C");
        System.out.println(list.equals(list1));
        System.out.println(list.equals(list2));

        List<Integer> listA = new ArrayList();
        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(4);
        listA.add(3);
        listA.add(4);

        List<Integer> listB = new ArrayList<>();
        listB.add(3);
        listB.add(4);
        listB.add(5);
        listB.add(6);

        /* 求并集 */
        //listA.addAll(listB);

        /* 求交集 */
        //listA.retainAll(listB);

        /* 求无重复并集 */
        listB.removeAll(listA);
        listB.addAll(listA);
        //listA.addAll(listB);
        for (Integer item : listB) {
            out.println(item);
        }
    }
}
