package main.com.mark.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author magaofei
 * @date 2021/9/5
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    private static final InheritableThreadLocal<String> inheritableLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        local.set("foo");
        inheritableLocal.set("foo");

        System.out.println(local.get());

        CompletableFuture.runAsync(() -> {
            System.out.println(local.get());
            System.out.println("inheritable + " + inheritableLocal.get());
        });
        TimeUnit.SECONDS.sleep(1);
    }
}
