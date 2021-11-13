package main.com.mark.concurrency;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskDisposeUtils {

    /**
     * 并发线程数
     */
    public static final int POOL_SIZE;

    static {
        POOL_SIZE = Integer.max(Runtime.getRuntime().availableProcessors(), 5);
    }

    public static <T> void dispose(List<T> taskList, Consumer<T> consumer) throws InterruptedException {
        dispose(true, POOL_SIZE, taskList, consumer);
    }

    public static <T> void dispose(boolean moreThread, int poolSize, List<T> taskList, Consumer<T> consumer) throws InterruptedException {
        if (taskList.isEmpty()) {
            return;
        }

        if (moreThread && poolSize > 1) {
            poolSize = Math.min(poolSize, taskList.size());
            ExecutorService executorService = null;
            try {
                executorService = Executors.newFixedThreadPool(poolSize);
                CountDownLatch countDownLatch = new CountDownLatch(taskList.size());
                for (T t : taskList) {
                    executorService.execute(() -> {
                        try {
                            consumer.accept(t);
                        } finally {
                            countDownLatch.countDown();
                        }
                    });
                }
                System.out.println("start await");
                countDownLatch.await();
                System.out.println("end await");
            } finally {
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        } else {
            for (T t : taskList) {
                consumer.accept(t);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Stream.iterate(1, a -> a + 1).limit(10).collect(Collectors.toList());
        TaskDisposeUtils.dispose(list, item -> {
            try {
                long startTime = System.currentTimeMillis();
                TimeUnit.SECONDS.sleep(item);
                long endTime = System.currentTimeMillis();
                System.out.println(System.currentTimeMillis() + ", 任务" + item + " 执行完毕，耗时：" + (endTime - startTime));
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(list + " 中的任务都处理完毕");
    }
}
