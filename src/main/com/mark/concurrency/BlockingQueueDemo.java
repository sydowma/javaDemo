package main.com.mark.concurrency;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueDemo<E> {
    int size;
    ReentrantLock lock = new ReentrantLock();
    LinkedList<E> list = new LinkedList<>();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public BlockingQueueDemo(int size) {
        this.size = size;
    }

    public void enqueue(E e) throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == size) {
                notFull.await();
            }
            list.add(e);
            System.out.println("入队 " + e);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        E e;
        lock.lock();
        try {
            while (list.size() == 0) {
                notEmpty.await();
            }
            e = list.removeFirst();
            System.out.println("出队 " + e);
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockingQueueDemo<Integer> queue = new BlockingQueueDemo<>(2);
        for (int i = 0; i < 10; i++) {
            int data = i;
            new Thread(() -> {
                try {
                    queue.enqueue(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Integer data = queue.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
