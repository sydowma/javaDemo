package main.com.mark.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author magaofei
 * @date 2021/7/11
 */
public class LockDemo {

    static class Foo {
        int i = 0;

        private synchronized void increase() {
            i++;
        }

        /**
         * not thread safe
         * 给方法加锁，相当于获取当前实例对象的锁，使用到该实例变量的时候，需要加锁
         */
        private void decrease() {
            i--;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

            for (int i = 0; i < 2000; i++) {
                executorService.execute(() -> {
                    foo.increase();
                });

            }


        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(foo.i);

    }
}
