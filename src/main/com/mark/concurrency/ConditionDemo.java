package main.com.mark.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author magaofei
 * @date 2021/9/5
 */
public class ConditionDemo {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        lock.lock();

        Condition condition = lock.newCondition();
        try {
            System.out.println("wait");
            CompletableFuture.runAsync(() -> {
                try {
                    lock.lock();
                    TimeUnit.SECONDS.sleep(1);
                    condition.signalAll();;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                System.out.println("sign");
            });
            condition.await();
            System.out.println("wait end");
        } finally {
            lock.unlock();
        }
    }

    public void test() throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(50);
        List<CompletableFuture<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futureList.add(CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println("run11");
                return "1111";
            }, executorService));
        }

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{}));
        CompletableFuture<List<String>> completableFuture1 = completableFuture.thenApply(v ->
                futureList.stream().map(CompletableFuture::join).collect(Collectors.toList()));
        System.out.println(completableFuture1.join());

    }
}
