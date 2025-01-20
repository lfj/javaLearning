package longlearn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDecimalFormat {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0");
        System.out.println(df.format(new Double("11.015")));
        System.out.println(df.format(new Double("11.004")));
        System.out.println(df.format(new Double("11.006")));
        System.out.println(df.format(new Double("11.1")));

        long a = -1L;
        System.out.println(new Date(0L));
        System.out.println(new Date(1L));
        System.out.println(new Date(2L));
        System.out.println(new Date(3L));

        List<String> list1 = new ArrayList<>();
        list1.add("crt");
        list1.add(null);
        for (String str: list1) {
            System.out.println("str = " + str);
        }
    }
}
