import java.util.Map;
import java.util.HashMap;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * 优化java程序的方法
 */
public class Test {

    private String lfj;

    public void Test() {

    }

    public static void main(String[] args){
        String abc = "abc" + 'a';
        /* 1.使用System.arraycopy代替循环复制数组 */
        int[] array1 = new int[5];
        for (int index = 0; index < array1.length; index ++) {
            array1[index] = index;
        }
        int[] array2 = new int[20];
        System.arraycopy(array1, 0, array2, 10, 2);

        /* 为Vector和HashTable还有HashMap定义初始大小 */
        Vector vector = new Vector(10);
        vector.add(1);
        vector.add("kkk");
        String kkk = "kkk";
        vector.remove(kkk);

        Hashtable hashtable = new Hashtable();
        hashtable.put("Moon", "b");
        //hashtable.put(null, "b");
        //hashtable.put("Jupiter", null);
        hashtable.put("Moon", "b");
        hashtable.put("Moon", "c");

        Map map = new HashMap(10, 0.75F);

        String str = "hello";
        String str1 = new String("hello");

    }
}
