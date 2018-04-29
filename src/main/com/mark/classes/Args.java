
package classes;
public class Args {

    private static double max (double ... values) {
        double largest = Double.NEGATIVE_INFINITY;
        for (double v: values) if (v > largest) largest = v;
        return largest;
    }
    public static void main(String[] args) {
        double m = max(1, 2,3,4, -1,5,6);
    }
}