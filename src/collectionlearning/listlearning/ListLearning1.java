package collectionlearning.listlearning;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类主要用来学习如何判断两个列表里面元素相同的情况
 */
public class ListLearning1 {
    public static void main(String[] args) {
        List lfjList1 = new ArrayList();
        lfjList1.add("a");
        lfjList1.add("b");
        lfjList1.add("c");
        lfjList1.add("d");
        lfjList1.add("e");
        lfjList1.add("f");

        List lfjList2 = new ArrayList();
        lfjList2.add("a");
        lfjList2.add("b");
        lfjList2.add("c");
        lfjList2.add("d");
        lfjList2.add("e");

        /* 第一种方法，这种方法不可以，只有在长度相等且对应index的每个元素都一样的情况下才行 */
        System.out.println("lfjList1.equals(lfjList2) = " + lfjList1.equals(lfjList2));

        /* 第二种方法可以，这个是求并集的情况 如果两个集合没有交集，则返回为false，因为没有修改 */
        System.out.println("lfjList1.retainAll(lfjList2) = " + lfjList1.retainAll(lfjList2));

        /* 第三种方法可以 */
        System.out.println("lfjList1.containsAll(lfjList2) && lfjList2.containsAll(lfjList1) = " + (lfjList1.containsAll(lfjList2) && lfjList2.containsAll(lfjList1)));

        /* System.out.println("lfjList1.removeAll(lfjList2) = " + lfjList1.removeAll(lfjList2)); */
    }
}
