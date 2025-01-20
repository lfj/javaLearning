package thread.jiaotiprint;

public class ThreadTest extends Thread {

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();

        thread1.start();

        thread2.start();

        thread3.start();

        for (int i = 0; i < 10; i++) {

        }
    }
}

class Thread1 extends Thread {

    String str = "A";

    @Override
    public void run() {

    }
}

class Thread2 extends Thread {

    String str = "B";

    @Override
    public void run() {

    }
}

class Thread3 extends Thread {

    String str = "C";

    @Override
    public void run() {

    }
}