
package collection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 可被迭代输出的数字类
 * 输入一个数字后， 倒序输出
 */

public class NumberDemo implements Iterable<Integer>{
    private int number;

    // private NumberDemo[] numberDemo;

    public NumberDemo (int number) {
        this.number = number;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NumberCollection();
    }

    class NumberCollection implements Iterator<Integer>{
        private int index = 1;
        private int value = 2;
    
        @Override
        public boolean hasNext() {
            return value > 1;
        }

        @Override
        public Integer next() {
            value = number / index % 10;
            index *= 10;
            return value;
        }

    }

    public static void main(String[] args) {
        NumberDemo n = new NumberDemo(1234);

        for (int i : n) {
            System.out.println("value " + i);
        }
    }
}


