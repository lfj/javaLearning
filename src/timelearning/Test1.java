package timelearning;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class Test1 {

    public static void main(String[] args) {
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String timestamp = date.getTime() + "";
        System.out.println("timestamp=" + timestamp);

        /**
         * string类型的timestamp转换成Date
         */
        String time = System.currentTimeMillis() + "";
        String time1 = null;
        String time2 = "";
        Timestamp timestamp1 = new Timestamp(Long.valueOf(time));
        Date date1 = timestamp1;

        /**
         * Date转换成timestamp
         */
        Date date2 = new Date();
        Timestamp timestamp2 = new Timestamp(date2.getTime());

        /**
         * Date转换成String
         */
        Date date3 = new Date();
        String date3_str = String.valueOf(date3);
    }
}
