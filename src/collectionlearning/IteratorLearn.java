package collectionlearning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;

public class IteratorLearn {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("张三1");
        list.add("张三2");
        list.add("张三3");
        list.add("张三4");
        out.println("使用迭代器的遍历方式");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            out.println(iterator.next());
        }
        out.println("使用第二种遍历方式");
        for (String name : list) {
            out.println(name);
        }
    }
}
