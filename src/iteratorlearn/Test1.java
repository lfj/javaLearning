package iteratorlearn;

import com.google.common.collect.Lists;
import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        Iterator iterator = list1.iterator();
        List<String> list2 = Lists.newArrayList(iterator);
        int i = 0;
        String str = null;

        Random rand =new Random(66);
        int ii = 0;
        ii = rand.nextInt(2);
        for (int n = 0; n < 100; n ++) {
            System.out.println("n=" + rand.nextInt(3));
        }
    }
}
