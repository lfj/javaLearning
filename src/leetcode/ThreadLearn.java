package leetcode;

import org.apache.kafka.common.protocol.types.Field;

public class ThreadLearn {

    private volatile int num;

    public static void main(String[] args) {
        Integer ee = Integer.MAX_VALUE;
        System.out.println(ee);
        Thread threadA = new Thread(() -> System.out.println("A"));
        Thread threadB = new Thread(() -> {
            try {
                threadA.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        });
        Thread threadC = new Thread(() -> {
            try {
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("C");
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }

}
