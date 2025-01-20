package timelearning;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test2 {
    public static void main(String[] args) {
        Long timestamp = 0L; //1582992000000L;
        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
        System.out.println("datetime=" + datetime);

        // 获取当天0点的时间戳

        //当前时间毫秒数
        long current = System.currentTimeMillis();

        //今天零点零分零秒的毫秒数
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();

        //今天零点零分零秒
        System.out.println(new Timestamp(zero));

        System.out.println(System.currentTimeMillis());
    }
}
