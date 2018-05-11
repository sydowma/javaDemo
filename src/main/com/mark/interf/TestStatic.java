
package interf;

interface Person {
    void print();
}

interface Student extends Person {
    void print();
}

/**
 *  测试接口是否默认是 static 和 final
 */
public class TestStatic implements Student{

    @Override
    public void print() {
        System.out.println("print()");    
    }
    public static void main(String[] args) {
        TestStatic t = new TestStatic();
        t.print();
    }
}