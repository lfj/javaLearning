package timelearning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static java.lang.System.out;

public class Test {

    public static String getLocalTime(String format, String utcTime) {

        try {
            if (null == format || "".equals(format)) {
                if (utcTime.length() == 20) {
                    format = "yyyy-MM-dd'T'HH:mm:ss'Z'";
                } else {
                    format = "yyyy-MM-dd'T'HH:mm'Z'";
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            String localTime;
            try {
                //专有云
                SimpleDateFormat localFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                localFormater.setTimeZone(TimeZone.getDefault());
                localTime = localFormater.format(sdf.parse(utcTime).getTime());
            } catch (ParseException e) {
                //公共云
                format = "yyyy-MM-dd'T'HH:mm'Z'";
                sdf = new SimpleDateFormat(format);
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                SimpleDateFormat localFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                localFormater.setTimeZone(TimeZone.getDefault());
                localTime = localFormater.format(sdf.parse(utcTime).getTime());
            }

            return localTime;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return utcTime;
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        out.println(date);

        /* 计算明天此刻的时间 */
        long time = date.getTime();
        time = time + 24 * 60 * 60 * 1000;
        date.setTime(time);
        out.println(date);

        Calendar calendar = Calendar.getInstance();
        String className = calendar.getClass().getName();
        System.out.println("calendar = " + calendar);
        System.out.println("className = " + className);

        String createTime = getLocalTime("yyyy-MM-dd'T'HH:mm:ss'Z'", "2019-06-05 13:39");
        int i = 0;
    }
}
