import java.util.Date;

/**
 * 静态
 */
public class Static {

    /** 静态方法中不能直接调用实例属性 */
    private String name = "mark";

    /**
     * 静态属性可以直接调用
     */
    private static int id = 1;

    /**
     * 静态方法可以由静态方法直接调用
     */
    private static int getId () {
        System.out.println(id);
        return id;
    }

    /**
     * 非静态方法或静态方法中都可以直接调用静态方法
     * 非静态方法必须实例化
     */
    private String getName () {
        getId();
        System.out.println(name);
        System.out.println(id);
        return this.name;
    }

    public static void main(String[] args) {
        getId();
        Static s = new Static();
        System.out.println(s.getName());
    }
}