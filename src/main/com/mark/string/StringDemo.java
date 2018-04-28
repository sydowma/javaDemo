

/**
 * @author mark
 * 
 */
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

    public static void main(String[] args) {
        StringDemo s = new StringDemo();
        boolean s1 = s.testEquals();
        boolean s2 = s.testEquals2();
        s.testBuilder();
        // System.out.println(s1);
        // System.out.println(s2);
    }
}
