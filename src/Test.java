import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    private String lfj;

    public void Test() {

    }

    public static void main(String[] args){
//        String tag = "uc0007LoginMsg";
//        Set tagSet = new HashSet();
//        tagSet.add("uc0007LoginMsg");
//        tagSet.add("uc0007Register");
//        tagSet.add("uc0007Certification");
//        if (tagSet.contains(tag)) {
//            System.out.println("在集群里");
//        } else {
//            System.out.println("不在集群里");
//        }
        //System.out.println(new Date().getTime() + "");
        //System.out.println(System.currentTimeMillis());

        Date date1 = new Date();
        System.out.println(date1);

        Date date2 = new Date(date1.getTime());
        System.out.println(date2);

        Date date3 = new Date(2018, 1, 12, 3, 15);

        Date date4 = new Date(2018, 2, 12, 3, 15);

        date3.before(date4);

        Date date5 = new Date();
        System.out.println("date5=" + date5);

        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String time2 = dateFormat.format(date5);
        System.out.println("time2=" + time2);

        String startTime = "2018-01-21 11:11:11";
        SimpleDateFormat dateFormat2 = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String time = dateFormat2.format((String) startTime);
        int i = 0;
    }
}
