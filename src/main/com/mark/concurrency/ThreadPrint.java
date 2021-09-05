package main.com.mark.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印
 * @author magaofei
 * @date 2021/9/5
 */
public class ThreadPrint {


    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private final int limit;
    private volatile int count;

    public ThreadPrint(int limit, int initCount) {
        this.limit = limit;
        this.count = initCount;
    }

    public void print()  {
        lock.lock();
        try {
            while (count < limit){
                System.out.println(String.format("线程[%s]打印数字:%d", Thread.currentThread().getName(), ++count));
                condition.signalAll();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    //ignore
                }
            }
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws Exception {
        ThreadPrint printer = new ThreadPrint(10, 0);
        Thread thread1 = new Thread(printer::print, "thread-1");
        Thread thread2 = new Thread(printer::print, "thread-2");
        thread1.start();
        thread2.start();
        Thread.sleep(Integer.MAX_VALUE);
    }


}
