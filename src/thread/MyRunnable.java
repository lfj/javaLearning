package thread;

import static java.lang.System.loadLibrary;
import static java.lang.System.out;

public class MyRunnable implements Runnable {

    private volatile boolean stopMe = false;

    @Override
    public void run() {
        out.println("运行中！");
        while (true) {
            if (stopMe) {
                out.println("exit  by stop me");
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.setName("我新创建的线程");
        System.out.println(thread.isAlive() + "the name of the thread is " + thread.getName());
        thread.start();
        System.out.println(thread.isAlive() + "the name of the thread is " + thread.getName());
    }
}
