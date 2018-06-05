package selfexception;

class CException extends Exception {

    public String toString () {
        return "CException";
    }
}

class AException extends Exception {

    public AException () throws CException {
        throw new CException();
    }

    public String toString () {
        return "AException";
    }
}

class BException extends Exception {

    public void AException () throws CException {
        throw new CException();
    }

    public String toString () {
        return "BException";
    }
}

public class MyException {

    public MyException () {}

    private void a() throws AException, CException {
        throw new AException();
    }

    private void b() throws BException, CException {
        throw new BException();
    }
    
    public static void main(String[] args) {
        try {
            MyException m = new MyException();
            m.a();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }


}