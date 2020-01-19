package thread;

import static java.lang.System.out;

public class SimpleWN {

    final static Object object = new Object();

    public static class T1 extends Thread {
        public void run() {
            synchronized (object) {
                out.println(System.currentTimeMillis() + ":T1 start");
                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for object ");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println(System.currentTimeMillis() + ":T1 start");
            }
        }
    }

    public static class T2 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T2 start! notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
