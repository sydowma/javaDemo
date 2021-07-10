package main.com.mark.generic;

import java.util.ArrayList;
import java.util.List;

class Fruit {

}
class Apple extends Fruit {

}
public class NonCovariantGenerics {
    List<Apple> fruit = new ArrayList<Apple>();
    // compile error 
    public static void main(String[] args) {
        NonCovariantGenerics n = new NonCovariantGenerics();
        System.out.println(n.fruit);
    }
}