package concurrencylearn.atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这里运行了二十个线程，若没有进行额外的同步操作，在多线程环境下就是不安全的，这个操作不具备原子性
 */
public class AtomicIntegerTest {

    private static final int THREADS_COUNT = 20;

    public static int count = 0;

    public volatile static int count1 = 0;

    public static AtomicInteger count2 = new AtomicInteger(0);

    public static void increase() {
        count++;
        count1++; //即使这个变量是volatile类型的，自增运算不是原子性的
        count2.incrementAndGet(); //这个方法是原子性的
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            }, "Thread" + i);
            threads[i].start();
        }
        while (1 < Thread.activeCount()) {
            Thread.yield();
        }
        System.out.println("count = " + count);
        System.out.println("count1 = " + count1);
        System.out.println("count2 = " + count2);
    }
}