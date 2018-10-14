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
        for (int i = 0; i < 100; i++) {

        }
        Date date2 = new Date(date1.getTime());
        System.out.println(date2);
    }
}
