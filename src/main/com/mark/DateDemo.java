// package main.com.mark;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateDemo {

    private void local() {
        
        System.out.println(LocalDate.now());
    }

    public static void main(String[] args) {
        // System.out.println(new Date());
        DateDemo dateDemo = new DateDemo();
        dateDemo.local();
    }

    GregorianCalendar someDay = new GregorianCalendar(1999, 11, 31);



}