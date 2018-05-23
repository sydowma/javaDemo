import javax.print.attribute.standard.Destination;

public class Parace10 {
    public Destination destination (final String dest, final float price) {
        return new Destination() {
            private int cost;
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget!");
                }
            }
            private String label = dest;
            public String readLabel() {
                return label;
            }
        };

    }
    public static void main(String... args) {
        Parace10 p = new Parace10();
        Destination d = p.destination("Tasmania", 101.395F);
    }
}