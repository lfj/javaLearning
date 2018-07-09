package 线程;

/**
 * 这里考的是Thread类中start()和run()方法的区别了。start()用来启动一个线程，当调用start方法后，系统才会开启一个新的线程，进而调用run()方法
 * 来执行任务，而单独的调用run()就跟调用普通方法是一样的，已经失去线程的特性了。因此在启动一个线程的时候一定要使用start()而不是run()。
 */
public class Thread1 {
    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");

    }

    static void pong() {
        System.out.print("pong");
    }
}
