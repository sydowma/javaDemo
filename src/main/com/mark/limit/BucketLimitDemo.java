package main.com.mark.limit;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class BucketLimitDemo {

    static class Node {
        private Thread thread;

        public Node(Thread thread) {
            this.thread = thread;
        }
    }

    public static class BucketLimit {
        static AtomicInteger threadNum = new AtomicInteger(1);

        private int capcity;
        private int flowRate;
        private TimeUnit flowRateUnit;
        private BlockingQueue<Node> queue;
        private long flowRateNanosTime;

        public BucketLimit(int capcity, int flowRate, TimeUnit flowRateUnit) {
            this.capcity = capcity;
            this.flowRate = flowRate;
            this.flowRateUnit = flowRateUnit;
            this.bucketThreadWork();
        }

        public void bucketThreadWork() {
            this.queue = new ArrayBlockingQueue<Node>(capcity);
            // 漏桶流出任务时间间隔
            this.flowRateNanosTime = flowRateUnit.toNanos(1) / flowRate;
            Thread thread = new Thread(this::bucketWork);
            thread.setName("漏桶线程-" + threadNum.getAndIncrement());
            thread.start();
        }

        private void bucketWork() {
            while (true) {
                Node node = this.queue.poll();
                if (Objects.nonNull(node)) {
                    // 唤醒任务线程
                    LockSupport.unpark(node.thread);
                }
                // 休眠，刮起当前线程 xx 秒
                LockSupport.parkNanos(this.flowRateNanosTime);
            }
        }

        public static BucketLimit build(int capcity, int flowRate, TimeUnit flowRateUnit) {
            return new BucketLimit(capcity, flowRate, flowRateUnit);
        }

        // 当前线程加入漏桶，返回 false，表示漏桶已满，true，表示漏桶限流成功，可以继续处理任务。
        public boolean acquire() {
            Thread thread = Thread.currentThread();
            Node node = new Node(thread);
            if (this.queue.offer(node)) {
                LockSupport.park();
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            BucketLimit bucketLimit = BucketLimit.build(10, 60, TimeUnit.MINUTES);
            for (int i = 0; i < 15; i++) {
                new Thread(() -> {
                    boolean acquire = bucketLimit.acquire();
                    System.out.println(Thread.currentThread().getName() + "  " + System.currentTimeMillis() + " " + acquire);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}
