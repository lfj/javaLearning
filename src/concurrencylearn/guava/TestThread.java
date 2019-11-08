package concurrencylearn.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 10, 60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(200),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        //模拟原始数据
        for (int i = 0; i < 1211; i++) {
            list.add(i + "-");
            System.out.println("添加原始数据:" + i);
        }

        int size = 50;//切分粒度，每size条数据，切分一块，交由一条线程处理
        int countNum = 0;//当前处理到的位置
        int count = list.size() / size;//切分块数
        int threadNum = 0;//使用线程数
        if (count * size != list.size()) {
            count++;
        }

        CountDownLatch countDownLatch = new CountDownLatch(count);

        //使用Guava的ListeningExecutorService装饰线程池
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(threadPoolExecutor);

        while (countNum < count * size) {
            //切割不同的数据块，分段处理
            threadNum++;
            countNum += size;
            MyCallable myCallable = new MyCallable();
            myCallable.setList(ImmutableList.copyOf(
                    list.subList(countNum - size, list.size() > countNum ? countNum : list.size())));

            ListenableFuture listenableFuture = executorService.submit(myCallable);

            //回调函数
            Futures.addCallback(listenableFuture, new FutureCallback<List<String>>() {
                //任务处理成功时执行
                @Override
                public void onSuccess(List<String> list) {
                    countDownLatch.countDown();
                    System.out.println("第h次处理完成");
                    result.addAll(list);
                }

                //任务处理失败时执行
                @Override
                public void onFailure(Throwable throwable) {
                    countDownLatch.countDown();
                    System.out.println("处理失败：" + throwable);
                }
            });

        }

        //设置时间，超时了直接向下执行，不再阻塞 方法结束后，由于子线程还是没有结束，所以主线程一直不能结束
        countDownLatch.await(3, TimeUnit.SECONDS);

        result.stream().forEach(s -> System.out.println(s));
        System.out.println("------------结果处理完毕，返回完毕,使用线程数量：" + threadNum);
    }
}

class MyCallable implements Callable {

    private List<String> list;

    @Override
    public Object call() throws Exception {
        List<String> listReturn = new ArrayList<>();
        //模拟对数据处理，然后返回
        for (int i = 0; i < list.size(); i++) {
            listReturn.add(list.get(i) + "：处理时间：" + System.currentTimeMillis() + "---:处理线程：" + Thread.currentThread());
        }

        return listReturn;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}