
package main.com.mark.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getStackTrace());
    }
}
public class FixedThreadPool {
    public static void main(String[] args) {
        // ExecutorService exec = Executors.newFixedThreadPool(5);
        // Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
  
        // for(int i = 0; i < 5; i++) {
        //     exec.execute(new LiftOff());
        //     throw new RuntimeException();
        // }
        // exec.shutdown();
  


        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.submit(() -> {
            Object obj = null;
            System.out.println(obj.toString());
        });
        threadPool.execute(() -> {
            Object obj = null;
            System.out.println(obj.toString());
        });
    }
}