package 线程;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("运行中！");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        System.out.println(thread.isAlive());
        thread.start();
        System.out.println(thread.isAlive());
    }
}
