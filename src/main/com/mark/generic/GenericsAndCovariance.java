package main.com.mark.generic;

import java.util.ArrayList;
import java.util.List;

//class Food {}
//class Fruit extends Food {}
//class Apple extends Fruit {}

public class GenericsAndCovariance {
    List<? extends Fruit> a = new ArrayList<Apple>();
    List<? extends Fruit> f = new ArrayList<Fruit>();
    // compile error 
    // 下界微 Fruit 
    // List<? super Fruit> s = new ArrayList<Apple>();
    List<? super Apple> s = new ArrayList<Fruit>();
    public static void main(String[] args) {
        GenericsAndCovariance g = new GenericsAndCovariance();
        g.s.add(new Apple());
        System.out.println(g.a);
        System.out.println(g.f);
    }
}