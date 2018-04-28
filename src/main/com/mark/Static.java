import java.util.Date;

public class Static {

    private String name = "mark";

    private static int id = 1;

    private static int getId () {
        System.out.println(id);
        return id;
    }

    private String getName () {
        return this.name;
    }

    public static void main(String[] args) {
        // getId();
        Static s = new Static();
        System.out.println(getName());
    }
}