package collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器
 */
public class Iter {

    private static void iter() {
        List<String> l = new ArrayList<String>();
        l.add("a");
        l.add("b");
        System.out.println(l);

        Iterator<String> lIter = l.iterator();
        while( lIter.hasNext() ) {
            System.out.println( lIter.next() );
        }
        for (String s : l) {
            System.out.println(s);
        }

    }
    public static void main(String[] args) {
        iter();
    }
}