package timelearning;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Test3 {
    public static void main(String[] args) throws ParseException {
/*        Long oldTime = null;
        long currentTimestamp = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = format.format4(currentTimestamp);

        Date today = format.parse(todayStr);
        // 昨天 86400000 = 24 * 60 * 60 * 1000 一天
        if ((today.getTime() - oldTime) > 0 && (today.getTime() - oldTime) <= 86400000) {
            System.out.println("说明是昨天");
        }*/

        Integer a = 1;
        Integer b = 1;
        int i = 0;

        long iD = 3 * 30 * 24 * 60 * 60 * 1000L;
        System.out.println(iD);

        long timeId = 1596435072749L;
        Instant instant = Instant.ofEpochMilli(timeId); // 将时间戳转换为Instant对象
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); // 将Instant对象转换为LocalDateTime对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // 指定日期格式
        String formattedDate = dateTime.format(formatter);

    }
}
