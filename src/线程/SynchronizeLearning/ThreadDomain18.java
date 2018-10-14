package 线程.SynchronizeLearning;

public class ThreadDomain18 {

    public void doLongTimeTask() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchronized threadName = " + Thread.currentThread().getName() + ", i = " + (i + 1));
        }
        System.out.println();
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName = " + Thread.currentThread().getName() + ", i = " + (i + 1));
            }
        }
    }

    public static void main(String[] args) {
        ThreadDomain18 td = new ThreadDomain18();
        MyThread18 mt0 = new MyThread18(td);
        MyThread18 mt1 = new MyThread18(td);
        mt0.start();
        mt1.start();
    }
}

class MyThread18 extends Thread {
    private ThreadDomain18 td;

    public MyThread18(ThreadDomain18 td) {
        this.td = td;
    }

    public void run() {
        try {
            td.doLongTimeTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
