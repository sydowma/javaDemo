package classes;

import classes.AbstractPerson;

public class Teacher extends AbstractPerson{

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void printName() {

    }

    public static void main(String[] args) {
        try {
            Object date = Class.forName("java.util.Date").newInstance();
            System.out.println(date);
        } catch (Exception e) {
            //TODO: handle exception
        }

    }

}