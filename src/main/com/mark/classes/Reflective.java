package classes;

import callby.Employee;

public class Reflective {



    public static void main(String[] args) {
        Employee e = new Employee("foo", 1);
        Class cl = e.getClass();
        String name = e.getClass().getName();
        System.out.println(name);

    }
}