package main.com.mark.classes.student;

public class Person {

    /**
     * 构造方法
     */
    private String privatepersonProperty = "privatePersonProperty";
    public String publicPersonProperty = "publicPersonProperty";

    private static String staticPersonProperty = "staticPersonPerty";

    /** first -1 
     * 父类的 static 域最先被执行
     */
    static {
        System.out.println("Person static area");
    }

    public static void testPersonStaticMethod() {
        System.out.println("Person call testPersonStaticMethod()");
    }

    public void testPersonMethod() {
        System.out.println("Person call testPersonMethod()");
    }

    /** 2 */
    Person() {
        
        System.out.println("construct Person()");
    }


}