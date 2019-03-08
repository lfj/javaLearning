package collectionlearning;

import java.util.HashMap;
import java.util.Map;

public class HashMapLearn {

    public static void main(String[] args) {
        /* HashMap的遍历 */
        Map<String, String[]> paramMap = new HashMap<>();
        paramMap.put("Nazi Germany", new String[]{"DivisionA", "DivisionB"});
        paramMap.put("Soviet Union", new String[]{"Division62", "Division63"});
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }
    }
}
