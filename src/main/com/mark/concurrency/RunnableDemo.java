package main.com.mark.concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Future;

public class RunnableDemo {


    static class Task implements Runnable {
        @Override
        public void run() {
            System.err.println("Runnable" + System.currentTimeMillis());
        }
    }

    private void testFuture() {

        ExecutorService executor = Executors.newCachedThreadPool();

        ArrayList<Future> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            Future future = executor.submit(task);
            list.add(future);
        }

        try {
            for (Future future : list) {
                System.out.println(future.isDone());
                future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            //TODO: handle exception
        }
        

        System.out.println("task finish");
    }

    public static void main(String[] args) {
        
        RunnableDemo r = new RunnableDemo();
        r.testFuture();
        
    }
}