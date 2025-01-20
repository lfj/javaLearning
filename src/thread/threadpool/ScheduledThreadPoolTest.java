package thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        // scheduledThreadPool.schedule(() -> System.out.println("delay 3 seconds"), 3, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(() -> {
            System.out.println("delay 1 seconds, and excute every 3 seconds");
            System.out.println(Thread.currentThread().getName() + "正处理");
        }, 1, 3, TimeUnit.SECONDS);
    }
}
