package classes;

import classes.AbstractPerson;
import classes.Teacher;

public class Student extends AbstractPerson{

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    
    @Override
    public void printName () {
        System.out.println(this.getName());
    
    }

    public static void main(String[] args) throws Exception{
        Student s1 = new Student();
        s1.setName("foo");
        System.out.println(s1.getName());
        s1.printName();

        System.out.println(s1.getClass());
        Teacher t1 = new Teacher();

        System.out.println("instanceof");

        if (s1.getClass() == s1.getClass()) {

            System.out.println("== \t"+ true);
        }


        if (s1 instanceof AbstractPerson) {

            System.out.println("instanceof \t"+ true);
        }

        

    }


}