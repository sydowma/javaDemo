package main.com.mark.concurrency.multithreading;


/**
 * ThreadStartVisibility
 */
public class ThreadStartVisibility {

    static int data = 0;
    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.println(data);
            }
        };

        data = 1;
        thread.start();

        try {
            Thread.sleep(50);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        data = 2;
        System.out.println(data);
        
        
    }
    
}