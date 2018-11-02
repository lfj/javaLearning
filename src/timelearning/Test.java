package timelearning;

import java.util.Calendar;
import java.util.Date;
import static java.lang.System.out;

public class Test {

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
    }
}
