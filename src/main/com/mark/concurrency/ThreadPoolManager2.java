package main.com.mark.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ThreadPoolManager2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.MINUTES, queue);
        CompletionService<String> completionService = new ExecutorCompletionService<>(threadPoolExecutor);

        List<Future<String>> futureList = new ArrayList<>();
        List<CompletableFuture<String>> completableFutures = new ArrayList<>();

        long start = System.currentTimeMillis();
        for (int i = 10; i > 1; i--) {
            int finalI = i;
            completableFutures.add(CompletableFuture.supplyAsync(() -> {
//            futureList.add(threadPoolExecutor.submit(() -> {
//            futureList.add(completionService.submit(() -> {
                try {
                    System.out.println("sleep  " + finalI);
                    TimeUnit.SECONDS.sleep(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "success";
            }, threadPoolExecutor));
        }

        List<String> r = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        CompletableFuture<Void> stringCompletableFuture = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));




//        for (int i = 0; i < futureList.size(); i++) {
////            completionService.take().get(10, TimeUnit.SECONDS);
//            futureList.get(i).get(10, TimeUnit.SECONDS);
//        }
//
//        System.out.println("result = " + (System.currentTimeMillis() - start) / 1000);

        Thread.currentThread().join();

    }
}
