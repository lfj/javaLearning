package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShowThreadRunnableStatus implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ShowThreadRunnableStatus(), "线程1");
        Thread t2 = new Thread(new ShowThreadRunnableStatus(), "线程2");
        Thread t3 = new Thread(new ShowThreadRunnableStatus(), "线程3");
        t1.join();
        t2.join();
        t3.join();
        t1.start();
        t2.start();
        t3.start();
        //thread.wait();
        /*List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ShowThreadRunnableStatus());
            thread.setName("无敌线程" + i);
            System.out.println("创建完线程的状态：" + thread.getState());
            thread.start();
            System.out.println("启动后线程的状态：" + thread.getState());
            threadList.add(thread);
        }*/
        /*boolean flag = false;
        while (!flag) {
            flag = true;
            for (Thread thread: threadList) {
                System.out.println(thread.getName() + "线程的状态：" + thread.getState());
                if (thread.isAlive()) {
                    flag = false;
                }
            }
        }*/
        System.out.println("所有线程均已死亡");
    }

    @Override
    public void run() {
        method();
        /*for (int i = 0; i < 800; i++) {
            System.out.println(i);
        }*/
    }

    private synchronized void method() {
        try {
            System.out.println(Thread.currentThread().getName() + "我是同步阻塞方法");
            //Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}
