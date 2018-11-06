

/**
 * @author mark
 * 
 */
package main.com.mark.string;

import java.awt.SystemTray;

public class StringDemo {

    private static final String foo = "foo";

    private boolean testEquals() {
        String foo = "foo";
        String bar = "foo";
        
        
        // String bar1 = bar + "1";
        // String bar2 = bar - "1";
        // return foo == bar2;
        // String bar1 =
        return foo == this.change(bar);
    }

    private static String change(String k) {
        String k1 = k + "1";
        // String k2 = k1 - "1";
        String k2 = k1.substring(0, 3);
        // System.out.println(k2);
        return k2;
    }

    private boolean testEquals2() {
        String foo = "foo";
        String bar = "foo";
        // bar += "1";
        // bar -= "1";
        return foo.equals(this.change(bar));
    }

    private void testBuilder() {
        StringBuilder builder = new StringBuilder();
        builder.append("f");
        builder.append("oo");
        System.out.println(builder.toString() == this.foo);
        System.out.println(builder.toString().equals(this.foo));

    }

    private static void testEquals3() {
        String n = "";

        long startTime1 = System.nanoTime();
        if ("".equals(n)) {
            System.out.println("equals " + 0);
        }

        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1);
        System.out.println("equals " + duration1);

        long startTime2 = System.nanoTime();
        if (n.isEmpty()) {
            System.out.println("isEmpty " + 0);
        }
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        System.out.println("isEmpty " + duration2);

        long startTime = System.nanoTime();

        if (n.length() == 0) {
            System.out.println("length " + 0);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("length " + duration);
    }

    private static void generate(String str) {
        System.out.println("string is ".format("%s", str));
    }

    public static String foo() {
        return "foo";
    }

    public static void main(String[] args) {

        
        System.out.println(foo().equals("213123"));
        System.out.println(foo() == new String("foo"));
        // StringDemo s = new StringDemo();
        // boolean s1 = s.testEquals();
        // boolean s2 = s.testEquals2();
        // s.testBuilder();
        // System.out.println(s1);
        // System.out.println(s2);
        // testEquals3();
    }
}
