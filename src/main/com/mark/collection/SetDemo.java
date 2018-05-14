
package collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    private static void hashSet() {
        Set<String> s = new HashSet<String>();
        for (int i = 0; i < 10; i++) {
            String temp = String.valueOf(i);
            s.add(temp);
        }

        for (int i = 0; i < 10; i++) {
            String temp = String.valueOf(i);
            s.add(temp);
        }
        System.out.println(s.getClass().toString() + s);
        
    }

    /**
     * Tree 有序Set 前提需要保证位数一致
     */
    private static void treeSet() {
        Set<String> s = new TreeSet<String>();
        for (int i = 10; i > 0; i--) {
            String temp = String.valueOf(i);
            s.add(temp);
        }
        System.out.println(s.getClass().toString() + s);
    }

    
    public static void main(String[] args) {
        hashSet();
        treeSet();
    }
}