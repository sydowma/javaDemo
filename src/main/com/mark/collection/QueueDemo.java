
package collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

    private static void priorityQueue() {
        Queue<String> q = new PriorityQueue<String>();
        q.add("a");
        q.add("b");
        q.offer("c");
        
        System.out.println(q);
    }

    private static void linkedList() {

    }

    public static void main(String[] args) {
        priorityQueue();
    }
}