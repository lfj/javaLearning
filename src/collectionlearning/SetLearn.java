package collectionlearning;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.lang.System.out;

/**
 * 学习笔记：
 * 1）Set不可以添加重复元素
 * 2）
 */
public class SetLearn {
    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add("China");
        set.add("Japan");
        set.add("USA");
        set.add("France");
        set.add("France");
        set.add(null);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            out.println(iterator.next());
        }
    }
}
