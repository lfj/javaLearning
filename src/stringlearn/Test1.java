package stringlearn;

import org.apache.commons.lang3.StringUtils;

public class Test1 {

    public static void main(String[] args) {
        String s1 = "-1";
        String s2 = "100";
        String s3 = "0";
        String s4 = " ";
        String s5 = "";
        String s6 = "1 ";
        String s7 = null;
        StringUtils.isNumeric(s1);
    }
}
