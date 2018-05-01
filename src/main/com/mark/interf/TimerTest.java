
package interf;

import java.util.Date;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;

public class TimerTest {
    public static void main(String[] args) {
        // 多态
        ActionListener listener = new TimePrinter();

        // construct a time that calls the listener
        // once every 10 seconeds
        Timer t = new Timer(10000, listener);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }

}

class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}