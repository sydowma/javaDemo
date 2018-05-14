
package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    private static final Integer MAX = 10;

    public ListDemo() {

    }

    private static void array() {
        int[] a = {0, 1, 2, 3};
        Integer[] b = { 0, 1, 2, 3 };
        System.out.println(a.toString());
        System.out.println(b.toString());
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

    

    public static void main(String[] args) {
        arrayList();
        array();
        linkedList();
    }
}