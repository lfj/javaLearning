package stringlearn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Test {
    public static void main(String[] args) {
        String str = "0123456789";
        String subStr = str.substring(0, 7);
        out.println("subStr = " + subStr);

        String str1 = "我是一个中国人，不是美国人";
        String subStr1 = str1.substring(0, 4);
        out.println("subStr1 = " + subStr1);

        String s2 = "a" + "b"; /* 常量池 */
        String s1 = "ab"; /* 常量池 */
        String s3 = "a";
        String s4 = "b";
        String s5 = s3 + s4; /* 堆区*/
        String s6 = new String("ab"); /* 堆区*/

        out.println(s1 == s2);
        out.println(s1 == s5);
        out.println(s2 == s5);
        out.println(s6 == s5);
        out.println(s6 == s2);
        out.println(s6 == s1);

        String strlfj = "a,b,c,d,e,f";
        List<String> array = Arrays.asList(strlfj.split(",")).stream().limit(4).collect(Collectors.toList());
    }
}
