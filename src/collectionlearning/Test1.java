package collectionlearning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

    public static final Pattern DEFAULT_NAME_PATTERN = Pattern.compile("^狐友[0-9]{13}$");

    public static void main(String[] args) {
//        Map map = new TreeMap<>();
//
//        StringBuffer stringBuffer = new StringBuffer("012345678");
//        stringBuffer.insert(1, "kkk");
//        boolean result = DEFAULT_NAME_PATTERN.matcher("狐友1231231231").matches();
//
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(1296000));
//        }

        String pathname = "D:\\opt\\logs\\sns-user-data-migration\\after\\data-sync.log-2020-04-30.log";
        File filename = new File(pathname);
        Pattern p = Pattern.compile("userId=.*的用户的");
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while(line != null) {
                line = br.readLine();
                System.out.println(line);
                Matcher m = p.matcher(line);
                if (m.find()) {
                    String userId = m.group().replace("userId=", "").replace("的用户的", "");
                    System.out.println("userId=" + userId);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
