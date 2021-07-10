package main.com.mark.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author magaofei
 * @date 2021/7/10
 */
public class HashMapInConcurrent {

    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < 500; i++) {
            int finalI = i;

            // not thread safe
            Executors.newFixedThreadPool(10).execute(() -> {

                for (int j = 0; j < 10; j++) {
                    map.put(String.valueOf(j), j);
                }

            });
        }

        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(map);
        System.out.println(map.size());


        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        for (int i = 0; i < 500; i++) {
            int finalI = i;
            Executors.newFixedThreadPool(10).execute(() -> {
                for (int j = 0; j < 100; j++) {
                    concurrentMap.put(String.valueOf(j), j);
                }
            });
        }

        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(concurrentMap);
        System.out.println(concurrentMap.size());
    }
}
