package thread;

import static java.lang.System.out;

public class Thread2 implements Runnable{

    @Override
    public void run() {
        while (true) {
            out.println("the state of the thread" + Thread.currentThread().getName() + " is " + Thread.currentThread().interrupted());
            out.println(Thread.currentThread().getName() + "线程还在执行中！");
            Thread.currentThread().yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Thread2(), "线程1");
        t1.start();
        Thread.sleep(3000);
        t1.interrupt();
    }
}

