package thread.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(20, 50,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                r -> new Thread(r, "t_pl_pool_" + r.hashCode()));
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "正处理"));
        }

        for (int i = 0; i < 10; i++) {
            executorService.submit(new TestCallable());
        }

        for (int i = 0; i < 10; i++) {
            executorService.submit(new TestCallable());
        }

        //处理完成后关闭线程池
        executorService.shutdown();
    }

    static class TestCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.currentThread().setName("selflearn");
            System.out.println("当前线程名字是：" + Thread.currentThread().getName());
            return "success";
        }
    }
}
