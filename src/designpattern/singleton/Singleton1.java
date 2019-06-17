package designpattern.singleton;

import static java.lang.System.out;

/**
 * 最普遍的单例模式，但是存在一个问题，任何调用类中静态变量的方法都会导致单例的初始化，即无法控制单例的创建时间
 */
public class Singleton1 {

    public static int status = 1;

    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
        out.println("Singleton1 has been created!");
    }

    public static Singleton1 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        out.println("Singleton1.status = " + Singleton1.status);
        Singleton1 singleton1 = Singleton1.getInstance();
    }
}

/**
 * 改进的单例模式，实现了延迟加载
 */
class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {
        out.println("Singleton2 has been created!");
    }

    public synchronized static Singleton2 getInstance() {
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * 第三种方法巧妙融合了以上的两种优点
 */
class Singleton3{

    private Singleton3() {
        out.println("Singleton3 has been created!");
    }

    private static class Singleton3Holder{
        private static Singleton3 instance = new Singleton3();
    }

    public Singleton3 getInstance() {
        return Singleton3Holder.instance;
    }
}
