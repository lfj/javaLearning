package collectionlearning;

import java.util.*;
import static java.lang.System.out;

public class learning1 {
    public static void main(String[] args) {
        List onlineUserList = new ArrayList();
        onlineUserList.add("顽石");
        onlineUserList.add("陈近南");
        onlineUserList.add("李三");
        onlineUserList.add("纬地");
        onlineUserList.add("毛迎明");
        onlineUserList.add("智空");
        onlineUserList.add("毛迎明");
        onlineUserList.add("纬地");

        onlineUserList.remove("纬地");
        int a = 0;

        Set srt = new HashSet();
        List newList = null;
        srt.addAll(newList);

        int[] data = {1, 2, 3, 4};
        List list = Arrays.asList(data);
        out.println(list.size());
    }
}
