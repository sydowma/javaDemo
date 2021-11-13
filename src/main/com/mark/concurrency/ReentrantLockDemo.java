package main.com.mark.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static int i = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);

        try {
            boolean success = lock.tryLock(10, TimeUnit.SECONDS);
            i++;
            System.out.println("lock result = " + success);
            System.out.println(" i = " + i);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }

    }
}
