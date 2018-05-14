
package collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * static 中可以调用实例方法
 * 实例方法可以调用 static 方法
 */


public class MapDemo {

    private void name() {
        System.out.println("name");
    }

    private void method1() {
        HashMap();
    }


    private static void HashMap() {


        Map<String, String> m = new HashMap<String, String>();
        m.put("foo", "bar");
        Class c = m.getClass();

        for (String var : m.keySet()) {
            System.out.println(var);
        }

        for (String var : m.values()) {
            System.out.println(var);
        }

        
        System.out.println(m.getClass().toString() + m);
        System.out.println(c);
    }

    private static void TreeMap() {
        Map<String, String> m = new TreeMap<String, String>();
        m.put("key", "value");
        m.put("1", "2");
        System.out.println(m.getClass().toString() + m);
    }

    private static void LinkedHashMap() {
        Map<String, String> m = new LinkedHashMap<String, String>();
        m.put("key", "value");
        System.out.println(m.getClass().toString() + m);

    }

    private static void concurrentHashMap() {
        Map<String, String> m = new ConcurrentHashMap<String, String>();
        m.put("key", "value");
        System.out.println(m.getClass().toString() + m);
    }
    
    public static void main(String[] args) {
        HashMap();
        TreeMap();
        LinkedHashMap();
        
    }
}