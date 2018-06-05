
package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class ListDemo {
    private static final Integer MAX = 10;

    public ListDemo() {

    }

    private static void array() {
        int[] a = {0, 1, 2, 3};
        Integer[] b = { 0, 1, 2, 3 };
        System.out.println(a.toString());
        System.out.println(b.toString());

        List newA = Arrays.asList(b);
        System.out.println(newA);
    }

    private static void arrayList() {
        List<Integer> l = new ArrayList<Integer>();
        for (Integer i = 0; i < MAX; i++) {
            l.add(i);
        }

        System.out.println(l.getClass().toString() + l);
        for (int i : l) {
            System.out.println(i);
        }
    }

    private static void linkedList() {
        List<Integer> l = new LinkedList<Integer>();
        for (Integer i = 0; i < MAX; i++) {
            l.add(i);
        }
        System.out.println(l.getClass().toString() + l);
        int last = l.lastIndexOf(1);
        
        List<Integer> ll = new ArrayList<Integer>(l);
        System.out.println("LinkedList to new ArrayList" + ll.getClass().toString() + ll);
    }

    private static void queue() {
        Queue<Integer> q = new LinkedBlockingQueue<Integer>();
        for (Integer i = 0; i < MAX; i++) {
            q.add(i);
        }
        
        System.out.println(q.getClass().toString() + q);
    }

    private static void copyOnWriteArrayList() {
        List<String> c = new CopyOnWriteArrayList<String>();
        
    }

    private static void subList() {
        List<String> s = new ArrayList<String>();
        s.add("a");
        s.add("b");
        s.add("c");

        List<String> newS = s.subList(2, 3);
        
        System.out.println(s);
        System.out.println(newS);
        newS.add("d");
        System.out.println(s);
    }

    

    

    public static void main(String[] args) {
        // arrayList();
        // array();
        // linkedList();
        // queue();
        // copyOnWriteArrayList();
        subList();
    }
}