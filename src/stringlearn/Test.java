package stringlearn;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import sun.net.NetProperties;

import static java.lang.System.out;

public class Test {
    public static void main(String[] args) {
        String str = "0123456789";
        String subStr = str.substring(0, 7);
        out.println("subStr = " + subStr);

        String str1 = "我是一个中国人，不是美国人";
        String subStr1 = str1.substring(0, 4);
        out.println("subStr1 = " + subStr1);

        String a = NetProperties.get("http.proxyHost");
        String b = NetProperties.get("http.proxyPort");
        }
    }
}
