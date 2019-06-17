package abstractclasslearn;

import static java.lang.System.out;

public class People {

    private static int num = 0;

    static {
        out.println("父类的静态代码块被调用！");
    }

    private String name;

    private int year;

    public static void  judgePeople() {
        System.out.println("People类的方法被调用！");
    }
}
