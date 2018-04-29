

package callby;

public class Employee {

    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return this.name + " " + this.id;
    }
}