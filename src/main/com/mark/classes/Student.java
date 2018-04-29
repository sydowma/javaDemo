package classes;

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

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("foo");
        System.out.println(s1.getName());
        s1.printName();

    }


}