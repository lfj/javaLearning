package thread.threadpool;

import java.util.concurrent.*;

public class FixedThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<?> future = executorService.submit(() -> {
            System.out.println("Task is running");
            throw new RuntimeException("Exception in submit");
        });

        // Check if the task has thrown an exception
        try {
            future.get(); // This will throw ExecutionException if an exception was thrown
        } catch (ExecutionException e) {
            System.out.println("Caught exception: " + e.getCause());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
