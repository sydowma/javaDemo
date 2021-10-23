package main.com.mark.collection;

import java.util.BitSet;

public class BitSetDemo {


    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.set(0);
        System.out.println(bitSet.get(1));
    }
}
