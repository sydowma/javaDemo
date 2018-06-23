package main.com.mark.arrays;

import java.util.*;
import java.util.ArrayList;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Sphere " + id;}
}

public class ArrayOfGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la;
        ls[0] = new ArrayList<String>();

        Object[] objects = ls;
        
        objects[1] = new ArrayList<Integer>();
        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[])new List[10];
        for (int i = 0; i < spheres.length; i++) {

            spheres[i] = new ArrayList<BerylliumSphere>();
        }
    
    }
}   