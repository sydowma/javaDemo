
package callby;
import callby.Employee;

/**
 * 按值传递还是按参数传递
 */
public class CallBy {

    /**
     * 方法不能让对象参数引用一个新的对象
     * 但是可以改变对象的属性
     */
    private static void swap(Employee a, Employee b) {
        Employee temp = a;
        a.setId(3);
        a.setName("fo3");
        a = b;
        b = temp;
    }

    
    public static void main(String[] args) {
        Employee foo = new Employee("foo", 1);
        Employee bar = new Employee("bar", 2);

        System.out.println(foo);
        /** 更改foo名称 */
        foo.setName("foo1");
        foo.setId(11);
        System.out.println(foo);
        System.out.println(bar);

        System.out.println("--------swap--------");
        swap(foo, bar);
        // Employee temp = foo;
        // foo = bar;
        // bar = temp;
        System.out.println(foo);
        System.out.println(bar);
    }
}