
package main.com.mark.concurrency;

import main.com.mark.concurrency.LiftOff;

public class BasicThread {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}