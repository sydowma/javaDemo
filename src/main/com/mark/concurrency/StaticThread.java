
package main.com.mark.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StaticThread {

    static int foo = 0;

    int bar = 0;

    static final int foo2 = 2;
    public static void main(String[] args) {
        // ExecutorService ex = Executors.newFixedThreadPool(50);
        List<Future> list = new ArrayList<>();

        StaticThread s = new StaticThread();
        for (int i = 0; i < 100; i++) {
            // list.add(ex.submit( ()-> {
            //     foo++;
            //     s.bar++;
            // }));
            new Thread() {
                public void run() {
                    foo += 2;
                    s.bar += 2;
                }
            }.start();
        }

        // try {
        //     for(Future future : list) {
        //         future.get();
        //     }
        // } catch (InterruptedException e) {
            
        // } catch (ExecutionException e) {
            
        // }
        
        System.out.println(foo);
        System.out.println(s.bar);
    }

    /**
     * @return the bar
     */
    public int getBar() {
        return bar;
    }

    /**
     * @param bar the bar to set
     */
    public void setBar(int bar) {
        this.bar = bar;
    }

    

    
}