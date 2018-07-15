
package main.com.mark.classes.student;

/**
 * 测试调用顺序
 */
public class Student extends Person {

    private String studentProperty = "studentProperty";
    private static String staticStudentProperty = "staticStudentPerty";

    /** 0 子类的 static 域第二被执行 */
    static {
        System.out.println("Student static area");
    }
    /**
     * 构造方法
     * 构造方法隐式的为 static 方法
     */
    /** 3 */
    Student () {
        // super();
        System.out.println("construct Student()");
        
        
    }

    /**
     * Java 不能重写 static 方法
     */
    // @Override
    public static void testPersonStaticMethod() {
        System.out.println("Student call testPersonStaticMethod()");
    }

    

    /** 5 */
    private void testStudnetMethod() {
        System.out.println("testStudnetMethod()");
    }

    /** 4 */
    @Override
    public void testPersonMethod() {
        System.out.println("Student call testPersonMethod()");
    }

    public static void main(String[] args) {
        /** 1 */
        System.out.println("main");
        Student student = new Student();
        student.testPersonMethod();
        student.testStudnetMethod();
    }


}