package main.com.mark.generic.coffee;

import java.util.Iterator;
import java.util.Random;

//class Coffee {}
//class Latte extends Coffee {}
//class Mocha extends Coffee {}
//class Cappuccino extends Coffee {}
//class Americano extends Coffee {}
//class Breve extends Coffee {}

interface Generator<T> {
    T next ();
}
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {
        Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class, };
    private static Random rand = new Random();
    public CoffeeGenerator() {}
    // for Iteration
    private int size = 0;
    public CoffeeGenerator(int sz) {
        size = sz;
    }
    public Coffee next() {
        try {
            return (Coffee)types[rand.nextInt(types.length)].newInstance();
        } catch( Exception e) {
            throw new RuntimeException();
        }
    }
        
    /**
     * 迭代器类
     */
    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        public boolean hasNext() {return count > 0;}
        public Coffee next() {
            count-- ;
            return CoffeeGenerator.this.next();
        }

        public void remove () {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Coffee> iterator () {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }

}
