package stringlearn;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * java以逗号为分隔符拼接字符串的技巧
 * 参考文档： https://blog.csdn.net/weixin_44124432/article/details/101050411
 */
public class Test2 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String urlString = "%3Cunknown+ssid%3E";
        String result = URLDecoder.decode(urlString, "UTF-8");
        // 第一种
        List<String> list = new ArrayList<>();
        list.add("Mxy");
        list.add("StringUtils");
        list.add("join");
        // 传入String类型的List集合，使用"-"号拼接
        String join = StringUtils.join(list, "-");
        // 输出 Mxy-StringUtils-join
        System.out.println("join=" + join);

        // 第二种
        String[] s = new String[]{"Yuan", "Mxy"};
        String join2 = StringUtils.join(s, "-");
        System.out.println("join2=" + join2);

        // 第三种
        //String result = Joiner.on(",").join(list);
        System.out.println(result);
    }
}
