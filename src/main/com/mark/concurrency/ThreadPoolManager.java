package main.com.mark.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author magaofei
 * @date 2021/7/10
 */
public class ThreadPoolManager {


    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10, TimeUnit.MINUTES, queue);
        for (int i = 0; i < 12; i++) {
            threadPoolExecutor.execute(() -> {
                String s = String.format("sleep 1s name = %s core_pool_size = %s , pool_size = %s", Thread.currentThread().getName(), threadPoolExecutor.getCorePoolSize(), threadPoolExecutor.getPoolSize());
                System.out.println(s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
