package main.com.mark.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {

            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new ExceptionThread());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
    
}