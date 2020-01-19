package utils;

import java.util.Properties;

public class Utils {

    /* 判断java运行的系统是否是linux */
    public static boolean isOSLinux() {
        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        if (os != null && os.toLowerCase().indexOf("linux") > -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(Utils.isOSLinux());

        int[] originArray = {1, 2, 3, 4, 5, 6, 7};
        int[] destArray = new int[7];

        /* 大规模复制提升效率要使用System.arraycopy方法 */
        System.arraycopy(originArray, 2, destArray, 0, 2);
        System.out.println(destArray.length);
    }
}
