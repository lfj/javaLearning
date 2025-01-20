package thread;

public class SelfThread extends Thread{

    @Override
    public void run() {
        System.out.println("A");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new SelfThread();
        thread.start();

        Runnable runnable = () -> {
            System.out.println("B");
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
        thread1.join();
        System.out.println("C");
    }
}
