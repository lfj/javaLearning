package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "正处理");
                System.out.println(index);
            });
        }
        cachedThreadPool.awaitTermination(10, TimeUnit.SECONDS);
        //cachedThreadPool.shutdown();
    }
}
