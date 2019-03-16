package main.com.mark.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample<T> {

    private static class TaskItem<T> {
        private BlockingQueue<T> blockingQueue = new LinkedBlockingQueue<>();
    }

    

    private static class Consumer implements Runnable {
        private TaskItem taskItem;

        public Consumer(TaskItem taskItem) {
            this.taskItem = taskItem;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    System.out.println("consumer start");
                    String item = (String)this.taskItem.blockingQueue.take();
                    System.out.println("consumer" + item);
                    System.out.println("consumer end");
                    System.out.println(Thread.currentThread());
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        
    }


    private static class Producer implements Runnable {
        private TaskItem taskItem;

        public Producer(TaskItem taskItem) {
            this.taskItem = taskItem;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    System.out.println("producer start");
                    this.taskItem.blockingQueue.put("apple");
                    System.out.println("producer apple");
                    System.out.println("producer end");

                    System.out.println(Thread.currentThread());
                    System.out.println("Thread sleep 2000");
                    // Thread.sleep(2000);
                
                }
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }


    }


    public static void main(String[] args) {
        System.out.println("main");

        TaskItem<String> taskItem = new TaskItem<>();

        LinkedBlockingQueueExample<String> linkedBlockingQueueExample = new LinkedBlockingQueueExample<>();
        LinkedBlockingQueueExample.Consumer consumer = new Consumer(taskItem);
        LinkedBlockingQueueExample.Producer producer = new Producer(taskItem);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producer);
        executorService.execute(producer);

        executorService.execute(consumer);

    }
}

